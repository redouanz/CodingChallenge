package com.hiddenfounders.repository;

import java.util.List;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.transaction.annotation.Transactional;

import com.hiddenfounders.entity.Shop;

@Transactional
public interface ShopRepository extends MongoRepository<Shop, String> {

	public Shop findByName(String name);
	
	@org.springframework.data.mongodb.repository.Query("{$and: [ {location:{ $near :{$geometry: { type: 'Point',  coordinates: [?1, ?2 ] } }}},{ $and: [{'disliked.username' : { '$nin' : [?0]} },{'prefered' : { '$nin' : [?0] } }]}]}")
	public List<Shop> findNearShop(String user, float lon, float lat);

	@org.springframework.data.mongodb.repository.Query("{$and: [ {location:{ $near :{$geometry: { type: 'Point',  coordinates: [?1, ?2 ] } }}},  {'prefered' : { '$in' : [?0] }}]}")

	public List<Shop> findNearPreferedShop(String c, float lon, float lat);

}