package com.api.Wallet.dto;

public class AssetAmountToBlockDto {
	
	private String userEmail;
	private String currencyTicker;
	private double amountToBlock;

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
	public double getAmountToBlock() {
		return amountToBlock;
	}
	public void setAmountToBlock(double amountToBlock) {
		this.amountToBlock = amountToBlock;
	}
	public AssetAmountToBlockDto(String userEmail, String currencyTicker, double amountToBlock) {
		super();
		this.userEmail = userEmail;
		this.currencyTicker = currencyTicker;
		this.amountToBlock = amountToBlock;
	}
	public AssetAmountToBlockDto() {
	}
	
}
