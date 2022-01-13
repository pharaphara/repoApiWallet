package com.api.Wallet.dto;

import com.api.Wallet.entity.Asset;

public class AssetDto {

		private Asset asset;

		public Asset getAsset() {
			return asset;
		}
		public void setAsset(Asset asset) {
			this.asset = asset;
		}

		public AssetDto() {
		}

		public AssetDto(Asset asset) {
			this.asset = asset;
		}	
		
}
