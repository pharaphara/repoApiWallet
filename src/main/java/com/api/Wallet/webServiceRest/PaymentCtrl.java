package com.api.Wallet.webServiceRest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.api.Wallet.dto.AllHistoryByUSerDto;
import com.api.Wallet.dto.AssetAmountToBlockDto;
import com.api.Wallet.dto.PaymentCbDto;
import com.api.Wallet.dto.PaymentDto;
import com.api.Wallet.dto.PaymentHistoryByCurrencyDto;
import com.api.Wallet.dto.ResultPaymentCbDto;
import com.api.Wallet.dto.TransfertDto;
import com.api.Wallet.dto.ResultTransfertDto;
import com.api.Wallet.service.ServicePayment;

@RestController
@RequestMapping(value="/assets-api-rest")
@CrossOrigin(origins = "*")
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
	
	@PostMapping("/sendPaymentCb")
	public ResponseEntity<ResultPaymentCbDto> sendPaymentCb(@RequestBody PaymentCbDto paymentCbDto) {
		ResultPaymentCbDto resultPaymentCbDto = servicePayment.sendPaymentCb(paymentCbDto);
		return new ResponseEntity<>(resultPaymentCbDto, HttpStatus.OK);
	}
	
	@GetMapping("/currencyHistory")
	public ResponseEntity<PaymentHistoryByCurrencyDto> paymentHistoryByCurrency(@RequestParam String userEmail, @RequestParam String currencyTicker){
		PaymentHistoryByCurrencyDto paymentHistoryByUserDto = servicePayment.paymentHistoryByCurrency(userEmail, currencyTicker);
		return new ResponseEntity<>(paymentHistoryByUserDto, HttpStatus.OK);
	}
	
	@GetMapping("/allHistory")
	public ResponseEntity<AllHistoryByUSerDto> getAllHistory(@RequestParam String userEmail){
		AllHistoryByUSerDto result = servicePayment.getAllHistory(userEmail);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
}
