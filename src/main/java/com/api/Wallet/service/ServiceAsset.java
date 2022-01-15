package com.api.Wallet.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.api.Wallet.dto.AssetAmountToBlockDto;
import com.api.Wallet.dto.AssetAvailableAmountDto;
import com.api.Wallet.dto.AssetDto;
import com.api.Wallet.dto.AssetsDto;
import com.api.Wallet.dto.PaymentDto;
import com.api.Wallet.entity.Asset;

public interface ServiceAsset {
	
	AssetsDto findAssetsByUser(String userEmail);
	AssetsDto findAllAssets();
	AssetDto findUserAssetByCurrency(String userEmail, String currencyTicker);
	Asset majAsset(PaymentDto paymentDto);
	AssetAvailableAmountDto getAvailableAmount(String userEmail, String currencyTicker);
	AssetAmountToBlockDto blockAmount(AssetAmountToBlockDto assetAmountToBlockDto);
}
