package com.api.Wallet.dto;

public class ResultTransfertDto {

		TransfertDto transfertDto;
		boolean transfertOk;
		String message;

		public TransfertDto getTransfertDto() {
			return transfertDto;
		}
		public void setTransfertDto(TransfertDto transfertDto) {
			this.transfertDto = transfertDto;
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
		public ResultTransfertDto() {
			super();
		}
		public ResultTransfertDto(TransfertDto transfertDto, boolean transfertOk, String message) {
			super();
			this.transfertDto = transfertDto;
			this.transfertOk = transfertOk;
			this.message = message;
		}
		
}
