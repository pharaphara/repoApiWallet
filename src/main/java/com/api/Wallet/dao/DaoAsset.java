package com.api.Wallet.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.api.Wallet.entity.Asset;

public interface DaoAsset extends CrudRepository<Asset, Integer>{

}
