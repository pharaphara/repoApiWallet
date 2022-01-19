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
		//Asset(String userEmail, String currencyTicker, double amount, double blockedAmount, double availableAmount)
		daoAsset.save(new Asset("bigbux@eqlexchange.io", "BTC", 1000, 1000, "EQL_0F887AC6986B00BBDE4AA91A0B82430A782E93603973AE81A6EC1041789EDA94"));
		daoAsset.save(new Asset("bigbux@eqlexchange.io", "EUR", 1000, 1000, "EQL_0F887AC6986B00BBDE4AA91A0B82430A782E93603973AE81A6EC1041789EDA94"));
		
		daoAsset.save(new Asset("alain.musque@yahoo.fr", "BTC", 5, 1, "EQL_DBF8B58DEC30242DD3E1A64331B9DACDB58CFA0F7742AA47E0984CF4098997AB"));
		daoAsset.save(new Asset("alain.musque@yahoo.fr", "BNB", 10, 0, "EQL_DBF8B58DEC30242DD3E1A64331B9DACDB58CFA0F7742AA47E0984CF4098997AB"));
		daoAsset.save(new Asset("alain.musque@yahoo.fr", "DOT", 245, 0, "EQL_DBF8B58DEC30242DD3E1A64331B9DACDB58CFA0F7742AA47E0984CF4098997AB"));
		daoAsset.save(new Asset("alain.musque@yahoo.fr", "ETH", 10, 0, "EQL_DBF8B58DEC30242DD3E1A64331B9DACDB58CFA0F7742AA47E0984CF4098997AB"));
		daoAsset.save(new Asset("alain.musque@yahoo.fr", "XRP", 50000, 0, "EQL_DBF8B58DEC30242DD3E1A64331B9DACDB58CFA0F7742AA47E0984CF4098997AB"));
		daoAsset.save(new Asset("alain.musque@yahoo.fr", "EUR", 1000000, 0, "EQL_DBF8B58DEC30242DD3E1A64331B9DACDB58CFA0F7742AA47E0984CF4098997AB"));


		daoAsset.save(new Asset("douilledu13@yopmail.com", "BTC", 1000, 1000, "EQL_DEBD5C88C70C54820665D03373F1DB3EFE45551F5D3856EDD6A9EAC7920435D7"));
		daoAsset.save(new Asset("douilledu13@yopmail.com", "EUR", 1000, 1000, "EQL_DEBD5C88C70C54820665D03373F1DB3EFE45551F5D3856EDD6A9EAC7920435D7"));
		
		daoAsset.save(new Asset("pouchard11@numericable.fr", "BTC", 1000, 1000, "EQL_DEBD5C88C70C54820665D03373F1DB3EFE45551F5D3856EDD6A9EAC7920435D9"));
		daoAsset.save(new Asset("pouchard11@numericable.fr", "EUR", 1000, 1000, "EQL_DEBD5C88C70C54820665D03373F1DB3EFE45551F5D3856EDD6A9EAC7920435D9"));
	}

}
