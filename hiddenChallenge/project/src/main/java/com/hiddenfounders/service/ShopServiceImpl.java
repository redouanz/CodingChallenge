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

import com.hiddenfounders.entity.DislikedShop;
import com.hiddenfounders.entity.Shop;
import com.hiddenfounders.entity.Usere;
import com.hiddenfounders.repository.*;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShopServiceImpl implements ShopService {
	private ShopRepository ShopRepository;

	@Autowired
	public ShopServiceImpl(ShopRepository ShopRepository) {
		this.ShopRepository =ShopRepository;
	}

	@Autowired
	MongoTemplate mongoTemplate;
/*
	@Override
	public int addDisliked(String user, String shop) {

		Query query = new Query(Criteria.where("username").is(user));
		Update update = new Update();
		update.push("shops", shop);
		WriteResult result = mongoTemplate.updateFirst(query, update, DislikedShop.class);

		if (result != null)
			return result.getN();
		else
			return 0;

	}

	@Override
	public int removeDisliked(String idUser,String idShop) {
		Query query = new Query(Criteria.where("username").is(idUser));
		Update update = new Update();
		update.pull("shops", idShop);
		WriteResult result = mongoTemplate.updateFirst(query, update, DislikedShop.class);

		if (result != null)
			return result.getN();
		else
			return 0;

	}

	@Override
	public DislikedShop findAllLikedShop(String username) {
		return DislikedShopRepository.findByUsernameLike(username);
	}

	@Override
	public DislikedShop save(String user, String shop) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DislikedShop> findByTimestampLessThan(int age) {
		// TODO Auto-generated method stub
		return null;
	}

	

	

	

	@Override
	public DislikedShop save(String user, String shop) {
		// TODO Auto-generated method stub
		return null;
	}*/

	@Override
	public int removeDisliked(String idShop, String idUser) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public DislikedShop findAllLikedShop(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int addDisliked(String Username, String shopDisliked) {
		// TODO Auto-generated method stub
		return 0;
	}

	

}
