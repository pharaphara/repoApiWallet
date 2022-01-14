package com.api.Wallet.dto;

import java.util.List;

public class AssetsDto {
	
	private List<AssetDto> assetsDto;

	public List<AssetDto> getAssetsDto() {
		return assetsDto;
	}
	
	public void setAssetsDto(List<AssetDto> assetsDto) {
		this.assetsDto = assetsDto;
	}

	public AssetsDto() {
	}

	public AssetsDto(List<AssetDto> assetsDto) {
		this.assetsDto = assetsDto;
	}

}
