package com.hiddenfounders.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.mongodb.WriteResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.hiddenfounders.entity.PreferedShop;
import com.hiddenfounders.entity.Shop;
import com.hiddenfounders.repository.ShopRepository;

import java.util.List;

@Service
public class PreferedShopServiceImpl implements PreferedShopService {

	@Autowired
	MongoTemplate mongoTemplate;

	private ShopRepository ShopRepository;

	@Autowired
	public PreferedShopServiceImpl(ShopRepository ShopRepository) {
		this.ShopRepository =ShopRepository;
	}

	
	@Override
	public void addPrefered(String user, String shop) {

		Query query = new Query(Criteria.where("name").is(shop));
		Update update = new Update();
		update.push("prefered", user);
		WriteResult result = mongoTemplate.updateFirst(query, update, Shop.class);
	}

	@Override
	public void removePrefered(String idUser,String idShop) {
		Query query = new Query(Criteria.where("name").is(idShop));
		Update update = new Update();
		update.pull("prefered", idUser);
		WriteResult result = mongoTemplate.updateFirst(query, update, Shop.class);
	}

	@Override
	public List<Shop> findAllLikedrShop(String username,float lon ,float lat) {
		Query query = new Query();
		//query.addCriteria(Criteria.where("prefered").is(username));
		
		//List<Shop> Shops = mongoTemplate.find(query, Shop.class);
		List<Shop> Shops=ShopRepository.findNearPreferedShop(username,lon,lat);
		return Shops;
	}


	

}
