package com.api.Wallet.dto;

import com.api.Wallet.entity.Asset;

public class AssetDto {

	private int id;
	private String userEmail;
	private String currencyTicker;
	private double amount;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getcurrencyTicker() {
		return currencyTicker;
	}
	public void setCurrencyId(String currencyTicker) {
		this.currencyTicker = currencyTicker;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	public AssetDto(int id, String userEmail, String currencyTicker, double amount) {
		super();
		this.id = id;
		this.userEmail = userEmail;
		this.currencyTicker = currencyTicker;
		this.amount = amount;
	}
	
	public AssetDto() {
	}	
		
}
