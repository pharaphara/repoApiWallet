package com.api.Wallet.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author formation
 *
 */
@Entity
public class Asset {
	
	@Id
	private int id;
	private String userEmail;
	private int currencyId;
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
	public int getCurrencyId() {
		return currencyId;
	}
	public void setCurrencyId(int currencyId) {
		this.currencyId = currencyId;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	public Asset(int id, String userEmail, int currencyId, double amount) {
		super();
		this.id = id;
		this.userEmail = userEmail;
		this.currencyId = currencyId;
		this.amount = amount;
	}
	
	public Asset() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "Asset [id=" + id + ", userEmail=" + userEmail + ", currencyId=" + currencyId + ", amount=" + amount
				+ "]";
	}
	
}
