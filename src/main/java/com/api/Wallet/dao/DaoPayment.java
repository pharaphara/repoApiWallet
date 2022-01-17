package com.api.Wallet.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.api.Wallet.entity.Asset;
import com.api.Wallet.entity.Payment;


public interface DaoPayment extends CrudRepository<Payment, Integer> {
	Optional<List<Payment>> findByAsset(Asset asset);
}
