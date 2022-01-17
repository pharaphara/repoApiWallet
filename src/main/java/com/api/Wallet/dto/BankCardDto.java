package com.api.Wallet.dto;

public class BankCardDto {

	private String number;
	private String date;
	private String cvvCode;

	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getCvvCode() {
		return cvvCode;
	}
	public void setCvvCode(String cvvCode) {
		this.cvvCode = cvvCode;
	}
	public BankCardDto() {
		super();
	}
	public BankCardDto(String number, String date, String cvvCode) {
		super();
		this.number = number;
		this.date = date;
		this.cvvCode = cvvCode;
	}
	
}
