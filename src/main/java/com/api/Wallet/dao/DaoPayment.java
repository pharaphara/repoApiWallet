package com.api.Wallet.dao;

import org.springframework.data.repository.CrudRepository;

import com.api.Wallet.entity.Payment;


public interface DaoPayment extends CrudRepository<Payment, Integer> {

}
