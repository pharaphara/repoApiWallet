package com.api.Wallet.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.api.Wallet.dao.DaoAsset;
import com.api.Wallet.dto.AssetDto;
import com.api.Wallet.dto.AssetsDto;
import com.api.Wallet.entity.Asset;

@Service
@Transactional
public class ServiceAssetImpl implements ServiceAsset{
	
	@Autowired
	private DaoAsset daoAsset;

	@Override
	public AssetsDto findAssetsByUser(String userEmail) {
		List<Asset> userAsset = getAssetByUser(userEmail);
		return new AssetsDto(userAsset);
	}

	@Override
	public AssetsDto findAllAssets() {
		List<Asset> allAsset = new ArrayList<Asset>();
		allAsset = (List<Asset>) daoAsset.findAll();
		return new AssetsDto(allAsset);
	}

	@Override
	public AssetDto findUserAssetByCurrency(String userEmail, int currencyId) {
		List<Asset> allUserAsset = getAssetByUser(userEmail);
		AssetDto result = null;
		for (Asset asset : allUserAsset) {
			if(asset.getCurrencyId() == currencyId) {
				result = new AssetDto(asset);
			}
		}
		return result;
	}
	
	private List<Asset> getAssetByUser(String userEmail) {
		List<Asset> allAsset;
		allAsset = (List<Asset>) daoAsset.findAll();
		List<Asset> result = new ArrayList<Asset>();
		for (Asset asset : allAsset) {
			if(asset.getUserEmail().equals(userEmail)) {
				result.add(asset);
			}
		}
		return result;
	}

}
