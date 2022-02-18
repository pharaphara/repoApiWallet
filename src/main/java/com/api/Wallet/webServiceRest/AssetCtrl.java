package com.api.Wallet.webServiceRest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value="/assets-api-rest")
@CrossOrigin(origins = "*")
public class AssetCtrl {
	
	@Autowired
	private ServiceAsset serviceAsset;
	
	@GetMapping("/userAssets")
	public ResponseEntity<List<AssetDto>> getAssetsByUser(@RequestParam(value="userEmail") String userEmail) {
		List<AssetDto> userAssets = serviceAsset.findAssetsByUser(userEmail);
		return new ResponseEntity<>(userAssets, HttpStatus.OK);
	}
	
	@GetMapping("/userAsset")
	public ResponseEntity<AssetDto> getUserAssetByCurrency(@RequestParam(value="userEmail") String userEmail, @RequestParam(value="currencyTicker") String currencyTicker) {
		AssetDto assetDto = serviceAsset.findUserAssetByCurrency(userEmail, currencyTicker);
		return new ResponseEntity<>(assetDto, HttpStatus.OK);
	}
	
	@GetMapping("/allAssets")
	public ResponseEntity<List<AssetDto>> getAllAssets() {
		List<AssetDto> allAssets = new ArrayList<>();
		allAssets = serviceAsset.findAllAssets();
		return new ResponseEntity<>(allAssets, HttpStatus.OK);
	}
	
	@GetMapping("/availableAmountAsset")
	public ResponseEntity<AssetAvailableAmountDto> getAvailableAmount(@RequestParam(value="userEmail") String userEmail, @RequestParam(value="currencyTicker") String currencyTicker) {
		AssetAvailableAmountDto assetAvailableAmountDto = serviceAsset.getAvailableAmount(userEmail, currencyTicker);
		return new ResponseEntity<>(assetAvailableAmountDto, HttpStatus.OK);
	}
	
	@PostMapping("/blockAmount")
	public ResponseEntity<AssetAmountToBlockDto> blockAmount(@RequestBody AssetAmountToBlockDto assetAmountToBlockDto) {
		AssetAmountToBlockDto result = serviceAsset.blockAmount(assetAmountToBlockDto);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
}
