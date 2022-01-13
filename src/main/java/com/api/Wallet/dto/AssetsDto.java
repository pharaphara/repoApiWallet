package com.api.Wallet.dto;

import java.util.List;

import com.api.Wallet.entity.Asset;

public class AssetsDto {
	
	private List<Asset> assets;

	public AssetsDto(List<Asset> assets) {
		super();
		this.assets = assets;
	}

	public List<Asset> getAssets() {
		return assets;
	}
	public void setAssets(List<Asset> assets) {
		this.assets = assets;
	}

	public AssetsDto() {
		super();
	}
	
}
