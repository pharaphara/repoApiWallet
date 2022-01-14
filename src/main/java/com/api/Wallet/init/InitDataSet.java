package com.api.Wallet.init;

import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import com.api.Wallet.dao.DaoAsset;
import com.api.Wallet.entity.Asset;

@Component
@Profile({"initDataSet"})
public class InitDataSet {
	
	@Autowired
	private DaoAsset daoAsset;
	
	@PostConstruct
	public void init() {
		daoAsset.save(new Asset(1, "a@gmail.com", "EUR", 1000));
		daoAsset.save(new Asset(2, "a@gmail.com", "BTC", 2000));
		daoAsset.save(new Asset(3, "b@gmail.com", "EUR", 3000));
		daoAsset.save(new Asset(4, "b@gmail.com", "BTC", 4000));
	}

}
