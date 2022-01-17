package com.api.Wallet.service;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.api.Wallet.dao.DaoAsset;
import com.api.Wallet.dao.DaoPayment;
import com.api.Wallet.dto.PaymentCbDto;
import com.api.Wallet.dto.PaymentDto;
import com.api.Wallet.dto.PaymentHistoryByCurrencyDto;
import com.api.Wallet.dto.PaymentWithDateDto;
import com.api.Wallet.dto.ResultPaymentCbDto;
import com.api.Wallet.dto.TransfertDto;
import com.api.Wallet.dto.BankCardDto;
import com.api.Wallet.dto.ResultTransfertDto;
import com.api.Wallet.entity.Asset;
import com.api.Wallet.entity.Payment;
import com.fasterxml.jackson.databind.deser.std.DateDeserializers.SqlDateDeserializer;

import io.netty.util.internal.StringUtil;

@Service
@Transactional
public class ServicePaymentImpl  implements ServicePayment{
	
	@Autowired
	private DaoPayment daoPayment;
	
	@Autowired
	private DaoAsset daoAsset;
	
	@Autowired
	private ServiceAsset serviceAsset;

	@Override
	public PaymentDto achievePayment(PaymentDto paymentDto) {
		// Recuperation de l'asset
		Asset asset = daoAsset.findByUserEmailAndCurrencyTicker(paymentDto.getUserEmail(), paymentDto.getCurrencyTicker()).get();
		//On realise le payment
		Asset assetMaj = serviceAsset.majAsset(asset, paymentDto.getMontant(), false);
		//On enregistre le payment
		daoPayment.save(new Payment(paymentDto.getMontant(), assetMaj));
		return paymentDto;
	}

	@Override
	public ResultTransfertDto transfertCurrency(TransfertDto transfertDto) {
		ResultTransfertDto resultTransfertDto = new ResultTransfertDto();
		resultTransfertDto.setTransfertDto(transfertDto);
		//Recuperation de l'asset envoyeur
		Asset assetEnvoyeur = daoAsset.findByUserEmailAndCurrencyTicker(transfertDto.getUserEmail(), transfertDto.getCurrencyTicker()).get();
		// Verification du montant disponible sur l'asset envoyeur
		double availableAmount = assetEnvoyeur.getAvailableAmount();
		if(availableAmount < transfertDto.getAmount()) {
			resultTransfertDto.setTransfertOk(false);
			resultTransfertDto.setMessage("Fonds disponibles insuffisants");
		}else {
			// Recuperation de l'asset receveur
			Optional<Asset> optionalAsset = daoAsset.findByWalletAdressAndCurrencyTicker(transfertDto.getWalletAdresse(), transfertDto.getCurrencyTicker());
			if(!optionalAsset.isPresent()) {
				resultTransfertDto.setTransfertOk(false);
				resultTransfertDto.setMessage("Adresse du wallet incorrect");
			}else {
				Asset assetReceveur = optionalAsset.get();
				// Réalisation des payments
				doPayment(assetEnvoyeur, -transfertDto.getAmount());
				doPayment(assetReceveur, transfertDto.getAmount());
				//Maj du resultTransfertDto
				resultTransfertDto.setTransfertOk(true);
				resultTransfertDto.setMessage("Transfert réussi");
			}
		}
		return resultTransfertDto;
	}
	
	public void doPayment(Asset asset, double amount) {
		Asset majAsset = serviceAsset.majAsset(asset, amount, true);
		Payment payment = new Payment(amount, majAsset);
		daoPayment.save(payment);
	}

	@Override
	public ResultPaymentCbDto sendPaymentCb(PaymentCbDto paymentCbDto) {
		ResultPaymentCbDto resultPaymentCbDto = new ResultPaymentCbDto();
		resultPaymentCbDto.setPaymentCbDto(paymentCbDto);
		BankCardDto bankCardDto = paymentCbDto.getBankCardDto();
		// Verification du format des informations
		if(!bankCardFormat(bankCardDto)) {
			resultPaymentCbDto.setTransfertOk(false);
			resultPaymentCbDto.setMessage("Erreur de saisie");
		}else {
			Optional<Asset> optionalAsset = daoAsset.findByUserEmailAndCurrencyTicker(paymentCbDto.getUserEmail(), paymentCbDto.getCurrecnticker());
			Asset asset = null;
			if(!optionalAsset.isPresent()) {
				// Création d'un nouvel asset s'il n'existe pas
				asset = new Asset(paymentCbDto.getUserEmail(), paymentCbDto.getCurrecnticker(), 0, 0, paymentCbDto.getWalletAdress());
			}else {
				asset = optionalAsset.get();
			}
			doPayment(asset, paymentCbDto.getAmount());
			resultPaymentCbDto.setTransfertOk(true);
			resultPaymentCbDto.setMessage("Dépôt réussi");
		}
		return resultPaymentCbDto;
	}
	
	public boolean bankCardFormat(BankCardDto bankCardDto) {
		final String numero = bankCardDto.getNumber();
		final String cvvCode = bankCardDto.getCvvCode();
		final String dateExpiration = bankCardDto.getDate();
		boolean result = true;
		if( numero == null || cvvCode == null || dateExpiration == null) {
			result = false;
		}else {
			// Variables Numeric
			if(!StringUtils.isNumeric(numero) || !StringUtils.isNumeric(dateExpiration) || !StringUtils.isNumeric(cvvCode)) {
				result = false;
			}
			// Bon nombre de carcatères
			if( numero.length() != 16 || cvvCode.length() != 3 || dateExpiration.length() != 4) {
				result = false;
			}else {
				// Date expiration supérieur à la date du jour
				String month = dateExpiration.substring(0, 2);
				String year = dateExpiration.substring(2, 4);
				String datePattern = new StringBuilder().append("20").append(year).append("-").append(month).append("-").append("28").toString();
				LocalDate dateFormatee = LocalDate.parse(datePattern, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
				if(dateFormatee.isBefore(LocalDate.now())) {
					result = false;
				}
			}
		}
		return result;
	}

	@Override
	public PaymentHistoryByCurrencyDto paymentHistoryByCurrency(String userEmail, String currencyTicker) {
		return getHistoryByCurrency(userEmail, currencyTicker);
	}
	
	public PaymentHistoryByCurrencyDto getHistoryByCurrency(String userEmail, String currencyTicker){
		// Recherche de tous les assets de l'utilisateur pour une currency
		Optional<Asset> userAsset = daoAsset.findByUserEmailAndCurrencyTicker(userEmail, currencyTicker);
		// Recupération des payments avec l'idAsset
		if(userAsset.isPresent()) {
			List<Payment> userPayments = (List<Payment>) daoPayment.findByAsset(userAsset.get()).get();
			List<PaymentWithDateDto> paymentsWithDateDto = new ArrayList<PaymentWithDateDto>();
			for (Payment payment : userPayments) {
				PaymentWithDateDto paymentWithDate= new PaymentWithDateDto(payment.getAmount(), payment.getDate());
				paymentsWithDateDto.add(paymentWithDate);
			}
			return new PaymentHistoryByCurrencyDto(paymentsWithDateDto, currencyTicker, userEmail);
		}else {
			return (PaymentHistoryByCurrencyDto) Collections.emptyList();
		}
	}
	
}
