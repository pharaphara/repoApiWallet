package com.api.Wallet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.api.Wallet.dao.DaoPayment;

@Service
@Transactional
public class ServicePaymentImpl {
	
	@Autowired
	private DaoPayment daoPayment;

}
