package com.api.Wallet.dto;

public class PaymentDto {
	
	private String currencyTicker;
	private String userEmail;
	private double montant;

	public String getCurrencyTicker() {
		return currencyTicker;
	}
	public void setCurrencyTicker(String currencyTicker) {
		this.currencyTicker = currencyTicker;
	}
	public double getMontant() {
		return montant;
	}
	public void setMontant(double montant) {
		this.montant = montant;
	}
	
	public PaymentDto(String currencyTicker, String userEmail, double montant) {
		super();
		this.currencyTicker = currencyTicker;
		this.userEmail = userEmail;
		this.montant = montant;
	}
	
	public PaymentDto() {
	}
	
}
