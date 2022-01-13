package com.api.Wallet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.api.Wallet.dto.AssetsDto;
import com.api.Wallet.service.ServiceAsset;
import com.api.Wallet.service.ServiceAssetImpl;
import com.api.Wallet.webServiceRest.AssetCtrl;

@SpringBootApplication
public class WalletApplication {

	public static void main(String[] args) {
		
		SpringApplication apiWallet = new SpringApplication(WalletApplication.class);
		
		//Alimentation BDD
		apiWallet.setAdditionalProfiles("initDataSet");
		ConfigurableApplicationContext context = apiWallet.run(args);		
	}

}
