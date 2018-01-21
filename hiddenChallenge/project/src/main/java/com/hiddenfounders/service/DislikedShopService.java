package com.hiddenfounders.service;

import java.util.List;

import com.hiddenfounders.entity.DislikedShop;
import com.hiddenfounders.entity.PreferedShop;


public interface DislikedShopService {

	//int removeDisliked(String idShop, String idUser);

	DislikedShop findAllLikedUsername(String username);

	//int addDisliked( String Username,String shopDisliked);
	
	//DislikedShop save(String user,String shop);

	void addDisliked(String user, String shop);



	void removeDisliked(String idUser);
	
	//List<DislikedShop>  findByTimestampLessThan(int age);


	


	
	

}
