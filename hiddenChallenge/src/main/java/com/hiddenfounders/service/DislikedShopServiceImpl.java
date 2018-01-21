
package com.hiddenfounders.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.hiddenfounders.dto.ShopDto;
import com.hiddenfounders.entity.Shop;
import com.hiddenfounders.entity.LikedShopTime;

@Service
public class DislikedShopServiceImpl implements DislikedShopService {

	@Autowired
	MongoTemplate mongoTemplate;

	@Autowired
	ShopService shopService;

	@Override
	public ShopDto addDisliked(String user, String shop) {

		Query query = new Query(Criteria.where("name").is(shop));
		Update update = new Update();
		update.push("disliked", new LikedShopTime(user, (long) System.currentTimeMillis() + 2 * 60 * 60 * 1000));
		mongoTemplate.updateFirst(query, update, Shop.class);
		ShopDto shopdto = shopService.findByName(shop);
		return shopdto;
	}

	@Override
	public void removeDisliked(String idUser) {
		Query query = new Query(Criteria.where("disliked.timestamp").lt(System.currentTimeMillis()));
		Update update = new Update();
		update.pull("disliked", new LikedShopTime(idUser));
		mongoTemplate.updateMulti(query, update, Shop.class);

	}
}
