package com.api.Wallet.service;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.api.Wallet.dao.DaoAsset;
import com.api.Wallet.dao.DaoPayment;
import com.api.Wallet.dto.PaymentDto;
import com.api.Wallet.dto.TransfertDto;
import com.api.Wallet.dto.ResultTransfertDto;
import com.api.Wallet.entity.Asset;
import com.api.Wallet.entity.Payment;
import com.fasterxml.jackson.databind.deser.std.DateDeserializers.SqlDateDeserializer;

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
		Asset asset = daoAsset.findByUserEmailAndCurrencyTicker(paymentDto.getUserEmail(), paymentDto.getCurrencyTicker());
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
		Asset assetEnvoyeur = daoAsset.findByUserEmailAndCurrencyTicker(transfertDto.getUserEmail(), transfertDto.getCurrencyTicker());
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
				//Instanciation de l'asset receveur
				Asset assetReceveur = optionalAsset.get();
				// Réalisation des payments
				Asset majAssetEnvoyeur = serviceAsset.majAsset(assetEnvoyeur, -transfertDto.getAmount(), true);
				Asset majAssetReceveur = serviceAsset.majAsset(assetReceveur, transfertDto.getAmount(), true);
				// Enregistrement des payments
				Payment sendPayment = new Payment(transfertDto.getAmount(), majAssetEnvoyeur);
				Payment receivePayment = new Payment(transfertDto.getAmount(), majAssetReceveur);
				daoPayment.save(sendPayment);
				daoPayment.save(receivePayment);
				//Maj du resultTransfertDto
				resultTransfertDto.setTransfertOk(true);
				resultTransfertDto.setMessage("Transfert réussi");
			}
		}
		return resultTransfertDto;
	}

}
