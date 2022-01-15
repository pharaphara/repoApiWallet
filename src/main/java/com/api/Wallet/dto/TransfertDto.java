package com.api.Wallet.dto;

public class TransfertDto {

	private String userEmail;
	private String currencyTicker;
	private String walletAdresse;
	private double amount;
	
	public TransfertDto(String userEmail, String currencyTicker, String walletAdresse, double amount) {
		super();
		this.userEmail = userEmail;
		this.currencyTicker = currencyTicker;
		this.walletAdresse = walletAdresse;
		this.amount = amount;
	}

	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getCurrencyTicker() {
		return currencyTicker;
	}
	public void setCurrencyTicker(String currencyTicker) {
		this.currencyTicker = currencyTicker;
	}
	public String getWalletAdresse() {
		return walletAdresse;
	}
	public void setWalletAdresse(String walletAdresse) {
		this.walletAdresse = walletAdresse;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public TransfertDto() {
		super();
	}
	
}
