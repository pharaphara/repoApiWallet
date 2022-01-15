package com.api.Wallet.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.api.Wallet.dao.DaoAsset;
import com.api.Wallet.dto.AssetAmountToBlockDto;
import com.api.Wallet.dto.AssetAvailableAmountDto;
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
		List<Asset> userAssets = getAssetsByUser(userEmail);
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

	@Override
	public AssetDto findUserAssetByCurrency(String userEmail, String currencyTicker) {
		List<Asset> allUserAsset = getAssetsByUser(userEmail);
		Asset asset = getAssetByCurrency(allUserAsset, currencyTicker);
		AssetDto result = new AssetDto(asset.getId(), asset.getUserEmail(), asset.getCurrencyTicker(), asset.getAmount());
		return result;
	}

	@Override
	public Asset majAsset(Asset asset, double montant, boolean isTransfert) {
		//Mis a jour du montant
		asset.setAmount(asset.getAmount() + montant);
		//Mis a jour du montant disponible s'il recoit de l'argent ou si c'est un transfert
		if(montant > 0 || isTransfert) {
			asset.setAvailableAmount(asset.getAvailableAmount() + montant);			
		}
		daoAsset.save(asset);
		return asset;
	}

	@Override
	public AssetAvailableAmountDto getAvailableAmount(String userEmail, String currencyTicker) {
		Asset asset = getUserAsset(userEmail, currencyTicker);
		return new AssetAvailableAmountDto(userEmail, currencyTicker, asset.getAvailableAmount());
	}
	
	@Override
	public AssetAmountToBlockDto blockAmount(AssetAmountToBlockDto assetAmountToBlockDto) {
		Asset asset = getUserAsset(assetAmountToBlockDto.getUserEmail(), assetAmountToBlockDto.getCurrencyTicker());
		asset.setAvailableAmount(asset.getAvailableAmount() - assetAmountToBlockDto.getAmountToBlock());
		daoAsset.save(asset);
		return assetAmountToBlockDto;
	}
	
	//Recuperation de l'asset d'un user
	private Asset getUserAsset(String userEmail, String currencyTicker) {
		return getAssetByCurrency(getAssetsByUser(userEmail), currencyTicker);
	}
	
	//Recuperation de tout les assets d'un user
	private List<Asset> getAssetsByUser(String userEmail) {
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
	
	//Recuperation de l'asset d'un user dans sa liste d'assets
	private Asset getAssetByCurrency(List<Asset> assets, String currencyTicker) {
		Asset result = null;
		for (Asset asset : assets) {
			if(asset.getCurrencyTicker().equals(currencyTicker)) {
				result = asset;
			}
		}
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

}
