package com.api.Wallet.dto;

public class ResultPaymentCbDto {

	private PaymentCbDto paymentCbDto;
	private boolean transfertOk;
	private String message;

	public PaymentCbDto getPaymentCbDto() {
		return paymentCbDto;
	}
	public void setPaymentCbDto(PaymentCbDto paymentCbDto) {
		this.paymentCbDto = paymentCbDto;
	}
	public boolean isTransfertOk() {
		return transfertOk;
	}
	public void setTransfertOk(boolean transfertOk) {
		this.transfertOk = transfertOk;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public ResultPaymentCbDto() {
		super();
	}
	public ResultPaymentCbDto(PaymentCbDto paymentCbDto, boolean transfertOk, String message) {
		super();
		this.paymentCbDto = paymentCbDto;
		this.transfertOk = transfertOk;
		this.message = message;
	}
	
}
