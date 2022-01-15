package com.api.Wallet.webServiceRest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.api.Wallet.dto.AssetAmountToBlockDto;
import com.api.Wallet.dto.AssetAvailableAmountDto;
import com.api.Wallet.dto.AssetDto;
import com.api.Wallet.dto.AssetsDto;
import com.api.Wallet.service.ServiceAsset;

@RestController
@RequestMapping(value="/assets-api-rest")
public class AssetCtrl {
	
	@Autowired
	private ServiceAsset serviceAsset;
	
	@GetMapping("/userAssets")
	public AssetsDto getAssetsByUser(@RequestParam(value="userEmail") String userEmail) {
		AssetsDto userAssets = serviceAsset.findAssetsByUser(userEmail);
		return userAssets;
	}
	
	@GetMapping("/userAsset")
	public AssetDto getUserAssetByCurrency(@RequestParam(value="userEmail") String userEmail, @RequestParam(value="currencyTicker") String currencyTicker) {
		AssetDto assetDto = serviceAsset.findUserAssetByCurrency(userEmail, currencyTicker);
		return assetDto;
	}
	
	@GetMapping("/allAssets")
	public AssetsDto getAllAssets() {
		AssetsDto allAssets = new AssetsDto();
		allAssets = serviceAsset.findAllAssets();
		return allAssets;
	}
	
	@GetMapping("/availableAmountAsset")
	public AssetAvailableAmountDto getAvailableAmount(@RequestParam(value="userEmail") String userEmail, @RequestParam(value="currencyTicker") String currencyTicker) {
		return serviceAsset.getAvailableAmount(userEmail, currencyTicker);
	}
	
	@PostMapping("/blockAmount")
	public AssetAmountToBlockDto blockAmount(@RequestBody AssetAmountToBlockDto assetAmountToBlockDto) {
		return serviceAsset.blockAmount(assetAmountToBlockDto);
	}
	
}
