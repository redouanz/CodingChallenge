package com.hiddenfounders.service;

import java.util.List;

import com.hiddenfounders.entity.PreferedShop;
import com.hiddenfounders.entity.Shop;


public interface PreferedShopService {

	void removePrefered(String idUser , String idShop);

	List<Shop> findAllLikedrShop(String username,float lon , float lat );

	void addPrefered( String Username,String shopPrefered);
	
	
	
	
}
