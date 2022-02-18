package com.api.Wallet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;

@SpringBootApplication
public class WalletApplication {

	public static void main(String[] args) {
		
		SpringApplication apiWallet = new SpringApplication(WalletApplication.class);
		
		//Alimentation BDD
		apiWallet.setAdditionalProfiles("initDataSet");
		ConfigurableApplicationContext context = apiWallet.run(args);		
	}

	

}
