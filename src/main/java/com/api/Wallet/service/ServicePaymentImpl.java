package com.api.Wallet.service;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.api.Wallet.dao.DaoPayment;
import com.api.Wallet.dto.PaymentDto;
import com.api.Wallet.entity.Asset;
import com.api.Wallet.entity.Payment;
import com.fasterxml.jackson.databind.deser.std.DateDeserializers.SqlDateDeserializer;

@Service
@Transactional
public class ServicePaymentImpl  implements ServicePayment{
	
	@Autowired
	private DaoPayment daoPayment;
	
	@Autowired
	private ServiceAsset serviceAsset;

	@Override
	public PaymentDto achievePayment(PaymentDto paymentDto) {
		//On realise le payment
		Asset assetMaj = serviceAsset.majAsset(paymentDto);
		//On enregistre le payment
		LocalDate paymentDate = LocalDate.now();
		Date sqlDate = Date.valueOf(paymentDate);
		daoPayment.save(new Payment(paymentDto.getMontant(), sqlDate, assetMaj));
		return paymentDto;
	}

}
