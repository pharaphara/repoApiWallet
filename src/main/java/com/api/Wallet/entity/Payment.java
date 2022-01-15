package com.api.Wallet.entity;

import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.beans.factory.annotation.Autowired;

@Entity
public class Payment {
	
	@Id
	@GeneratedValue
	private int id;
	private double amount;
	private Date date;
	
	@ManyToOne
	@JoinColumn(name = "id_asset")
	private Asset asset;

	public Payment(double amount, Asset asset) {
		super();
		this.amount = amount;
		LocalDate paymentDate = LocalDate.now();
		Date sqlDate = Date.valueOf(paymentDate);
		this.date = sqlDate;
		this.asset = asset;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Asset getAsset() {
		return asset;
	}
	public void setAsset(Asset asset) {
		this.asset = asset;
	}
	public Payment() {
	}	
	
}
