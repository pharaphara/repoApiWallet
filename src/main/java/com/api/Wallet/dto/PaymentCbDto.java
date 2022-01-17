package com.api.Wallet.dto;

public class PaymentCbDto {

	private String userEmail;
	private String currecnticker;
	private String walletAdress;
	private double amount;
	private BankCardDto bankCardDto;

	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getCurrecnticker() {
		return currecnticker;
	}
	public void setCurrecnticker(String currecnticker) {
		this.currecnticker = currecnticker;
	}
	public String getWalletAdress() {
		return walletAdress;
	}
	public void setWalletAdress(String walletAdress) {
		this.walletAdress = walletAdress;
	}
	public BankCardDto getBankCardDto() {
		return bankCardDto;
	}
	public void setBankCardDto(BankCardDto bankCardDto) {
		this.bankCardDto = bankCardDto;
	}
	public PaymentCbDto() {
		super();
	}
	public PaymentCbDto(String userEmail, String currecnticker, String walletAdress, double amount,
			com.api.Wallet.dto.BankCardDto bankCardDto) {
		super();
		this.userEmail = userEmail;
		this.currecnticker = currecnticker;
		this.walletAdress = walletAdress;
		this.amount = amount;
		this.bankCardDto = bankCardDto;
	}
	
}
