package com.api.Wallet.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.api.Wallet.entity.Asset;

public interface DaoAsset extends CrudRepository<Asset, Integer>{

	Optional<Asset> findByWalletAdressAndCurrencyTicker(String walletAdresse, String currencyTicker);
	Optional<Asset> findByUserEmailAndCurrencyTicker(String email, String currencyTicker);

}
