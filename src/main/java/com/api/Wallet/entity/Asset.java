package com.api.Wallet.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Asset {
	
	@Id
	private int id;
	private String userEmail;
	private int currencyId;
	private double amount;
	
	@OneToMany(mappedBy ="asset")
	private List<Payment> payments;

	
	public Asset(int id, String userEmail, int currencyId, double amount) {
		super();
		this.id = id;
		this.userEmail = userEmail;
		this.currencyId = currencyId;
		this.amount = amount;
	}
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
	public List<Payment> getPayments() {
		return payments;
	}
	public void setPayments(List<Payment> payments) {
		this.payments = payments;
	}
	public Asset(int id, String userEmail, int currencyId, double amount, List<Payment> payments) {
		super();
		this.id = id;
		this.userEmail = userEmail;
		this.currencyId = currencyId;
		this.amount = amount;
		this.payments = payments;
	}
	public Asset() {
	}
	

	
}
