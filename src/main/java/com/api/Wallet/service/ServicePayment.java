package com.api.Wallet.service;

import com.api.Wallet.dto.PaymentDto;
import com.api.Wallet.dto.TransfertDto;
import com.api.Wallet.dto.ResultTransfertDto;

public interface ServicePayment {
	
	public PaymentDto achievePayment(PaymentDto paymentDto);
	public ResultTransfertDto transfertCurrency(TransfertDto transfertDto);
}
