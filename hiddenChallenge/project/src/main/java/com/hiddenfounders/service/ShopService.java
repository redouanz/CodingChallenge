package com.hiddenfounders.service;

import java.util.List;

import com.hiddenfounders.entity.DislikedShop;
import com.hiddenfounders.entity.Shop;


public interface ShopService {

	int removeDisliked(String idUser,String idShop);

	DislikedShop findAllLikedShop(String username);

	int addDisliked( String Username,String shopDisliked);
	
	
}
