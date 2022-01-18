package com.api.Wallet.service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

import com.api.Wallet.dto.AllHistoryByUSerDto;
import com.api.Wallet.dto.PaymentCbDto;
import com.api.Wallet.dto.PaymentDto;
import com.api.Wallet.dto.PaymentHistoryByCurrencyDto;
import com.api.Wallet.dto.ResultPaymentCbDto;
import com.api.Wallet.dto.TransfertDto;
import com.api.Wallet.dto.ResultTransfertDto;

public interface ServicePayment {
	
	public PaymentDto achievePayment(PaymentDto paymentDto);
	public ResultTransfertDto transfertCurrency(TransfertDto transfertDto);
	public ResultPaymentCbDto sendPaymentCb(PaymentCbDto paymentCbDto);
	public PaymentHistoryByCurrencyDto paymentHistoryByCurrency(String userEmail, String currencyTicker);
	public AllHistoryByUSerDto getAllHistory(String userEmail);
}
