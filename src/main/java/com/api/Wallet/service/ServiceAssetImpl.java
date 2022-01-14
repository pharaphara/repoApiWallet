package com.api.Wallet.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.api.Wallet.dao.DaoAsset;
import com.api.Wallet.dto.AssetDto;
import com.api.Wallet.dto.AssetsDto;
import com.api.Wallet.dto.PaymentDto;
import com.api.Wallet.entity.Asset;

@Service
@Transactional
public class ServiceAssetImpl implements ServiceAsset{
	
	@Autowired
	private DaoAsset daoAsset;

	@Override
	public AssetsDto findAssetsByUser(String userEmail) {
		List<Asset> userAssets = getAssetByUser(userEmail);
		AssetsDto result = assetsToAssetsDto(userAssets);
		return result;
	}

	@Override
	public AssetsDto findAllAssets() {
		List<Asset> allAsset = new ArrayList<Asset>();
		allAsset = (List<Asset>) daoAsset.findAll();
		AssetsDto result = assetsToAssetsDto(allAsset);
		return result;	
	}

	private AssetsDto assetsToAssetsDto(List<Asset> allAsset) {
		List<AssetDto> assetsDto = new ArrayList<AssetDto>();
		for (Asset asset : allAsset) {
			AssetDto assetDto = new AssetDto(asset.getId(), asset.getUserEmail(), asset.getCurrencyTicker(), asset.getAmount());
			assetsDto.add(assetDto);
		}
		AssetsDto result = new AssetsDto(assetsDto);
		return result;
	}

	@Override
	public AssetDto findUserAssetByCurrency(String userEmail, String currencyTicker) {
		List<Asset> allUserAsset = getAssetByUser(userEmail);
		Asset asset = getAssetByCurrency(allUserAsset, currencyTicker);
		AssetDto result = new AssetDto(asset.getId(), asset.getUserEmail(), asset.getCurrencyTicker(), asset.getAmount());
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
	
	private Asset getAssetByCurrency(List<Asset> assets, String currencyTicker) {
		Asset result = null;
		for (Asset asset : assets) {
			if(asset.getCurrencyTicker().equals(currencyTicker)) {
				result = asset;
			}
		}
		return result;	
	}

	@Override
	public Asset majAsset(PaymentDto paymentDto) {
		List<Asset> allUserAsset = getAssetByUser(paymentDto.getUserEmail());
		Asset asset = getAssetByCurrency(allUserAsset, paymentDto.getCurrencyTicker());
		Double montantInitial = asset.getAmount();
		asset.setAmount(montantInitial + paymentDto.getMontant());
		daoAsset.save(asset);
		return asset;
	}

}
