package com.api.Wallet.dto;

public class AssetAvailableAmountDto {
	
	private String userEmail;
	private String currencyTicker;
	private double availableAmount;
	
	public AssetAvailableAmountDto(String userEmail, String currencyTicker, double availableAmount) {
		this.userEmail = userEmail;
		this.currencyTicker = currencyTicker;
		this.availableAmount = availableAmount;
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
	public double getAvailableAmount() {
		return availableAmount;
	}
	public void setAvailableAmount(double availableAmount) {
		this.availableAmount = availableAmount;
	}
	public AssetAvailableAmountDto() {
	}
	
}
