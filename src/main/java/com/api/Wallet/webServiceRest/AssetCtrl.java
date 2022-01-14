package com.api.Wallet.webServiceRest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.api.Wallet.dto.AssetDto;
import com.api.Wallet.dto.AssetsDto;
import com.api.Wallet.service.ServiceAsset;

@RestController
@CrossOrigin(origins = { "http://localhost:3000" , "http://localhost:4200" } , methods = { RequestMethod.GET , RequestMethod.POST , RequestMethod.PUT , RequestMethod.DELETE })
@RequestMapping(value="/assets-api-rest")
public class AssetCtrl {
	
	@Autowired
	private ServiceAsset serviceAsset;
	
	@PostMapping("/userAssets")
	public AssetsDto getAssetsByUser(@RequestParam(value="userEmail") String userEmail) {
		AssetsDto userAssets = serviceAsset.findAssetsByUser(userEmail);
		return userAssets;
	}
	
	@PostMapping("/userAsset")
	public AssetDto getUserAssetByCurrency(@RequestParam(value="userEmail") String userEmail, @RequestParam(value="currencyId") int currencyId) {
		AssetDto assetDto = serviceAsset.findUserAssetByCurrency(userEmail, currencyId);
		return assetDto;
	}
	
	@PostMapping("/allAssets")
	public AssetsDto getAllAssets() {
		AssetsDto allAssets = new AssetsDto();
		allAssets = serviceAsset.findAllAssets();
		return allAssets;
	}
	
}
