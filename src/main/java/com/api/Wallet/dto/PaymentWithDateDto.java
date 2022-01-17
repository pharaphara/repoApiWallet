package com.api.Wallet.dto;

import java.time.LocalDateTime;

public class PaymentWithDateDto {
	
	private double amount;
	private LocalDateTime date;

	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public LocalDateTime getDate() {
		return date;
	}
	public void setDate(LocalDateTime date) {
		this.date = date;
	}
	public PaymentWithDateDto() {
		super();
	}
	public PaymentWithDateDto( double amount, LocalDateTime date) {
		super();
		this.amount = amount;
		this.date = date;
	}
	
}
