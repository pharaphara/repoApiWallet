package com.api.Wallet.dto;

import java.util.List;

public class PaymentHistoryByCurrencyDto {
	private List<PaymentWithDateDto> paymentsWithDate;
	private String CurrencyTicker;
	private String userEmail;

	public List<PaymentWithDateDto> getPaymentsWithDate() {
		return paymentsWithDate;
	}
	public void setPaymentsWithDate(List<PaymentWithDateDto> paymentsWithDate) {
		this.paymentsWithDate = paymentsWithDate;
	}
	public String getCurrencyTicker() {
		return CurrencyTicker;
	}
	public void setCurrencyTicker(String currencyTicker) {
		CurrencyTicker = currencyTicker;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public PaymentHistoryByCurrencyDto() {
		super();
	}
	public PaymentHistoryByCurrencyDto(List<PaymentWithDateDto> paymentsWithDate, String currencyTicker,
			String userEmail) {
		super();
		this.paymentsWithDate = paymentsWithDate;
		CurrencyTicker = currencyTicker;
		this.userEmail = userEmail;
	}
	
}
