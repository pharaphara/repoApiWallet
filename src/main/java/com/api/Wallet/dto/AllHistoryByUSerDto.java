package com.api.Wallet.dto;

import java.util.List;

public class AllHistoryByUSerDto {
	
	private List<PaymentHistoryByCurrencyDto> payments;

	public List<PaymentHistoryByCurrencyDto> getPayments() {
		return payments;
	}
	public void setPayments(List<PaymentHistoryByCurrencyDto> payments) {
		this.payments = payments;
	}
	public AllHistoryByUSerDto() {
		super();
	}
	public AllHistoryByUSerDto(List<PaymentHistoryByCurrencyDto> payments) {
		super();
		this.payments = payments;
	}

}
