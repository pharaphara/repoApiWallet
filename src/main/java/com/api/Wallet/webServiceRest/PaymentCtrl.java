package com.api.Wallet.webServiceRest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.Wallet.dto.PaymentDto;
import com.api.Wallet.dto.TransfertDto;
import com.api.Wallet.dto.ResultTransfertDto;
import com.api.Wallet.service.ServicePayment;

@RestController
@RequestMapping(value="/assets-api-rest")
public class PaymentCtrl {
	
	@Autowired
	private ServicePayment servicePayment;
	
	@PostMapping("/sendPayment")
	public PaymentDto sendPayment(@RequestBody PaymentDto paymentDto) {
		return servicePayment.achievePayment(paymentDto);
	}
	
	@PostMapping("/transfertCurrency")
	public ResultTransfertDto transfertCurrency(@RequestBody TransfertDto transfertDto) {
		return servicePayment.transfertCurrency(transfertDto);
	}
	
}
