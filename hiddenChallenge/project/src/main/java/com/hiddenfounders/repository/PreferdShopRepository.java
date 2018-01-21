package com.hiddenfounders.repository;

import java.util.List;

import com.hiddenfounders.entity.Shop;


/*
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.concretepage.entity.PreferedShop;


@Transactional
public interface PreferdShopRepository extends MongoRepository<Shop, String> {

	 
	//public PreferedShop findByUsernameLike(String user);// get all liked shops for a user 
	
	
	@org.springframework.data.mongodb.repository.Query("{$and: [ {location:{ $near :{$geometry: { type: 'Point',  coordinates: [?1, ?2 ] } }}},  {'prefered' : { '$in' : [?0] }}]}")
			//{$and: [ {location:{ $near :{$geometry: { type: 'Point',  coordinates: [?1, ?2 ] } }}}, {'prefered' : { '$in' : [?0]} }]}" )
														
	
	public List<Shop> findNearShop(String c,float lon , float lat );
	
	

	

}*/