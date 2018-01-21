package com.hiddenfounders.repository;


import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.hiddenfounders.entity.DislikedShop;
import com.hiddenfounders.entity.PreferedShop;


@Transactional
public interface DislikedShopRepository extends MongoRepository<DislikedShop, String> {

	 
	public DislikedShop findByUsernameLike(String username);
	
	/*public List<DislikedShop> findByTimestampGreaterThan(int age);
	
	public List<DislikedShop> findByTimestampLessThan(int age);
	*/
	
	
	

	

}