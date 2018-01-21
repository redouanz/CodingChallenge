
package com.hiddenfounders.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import com.mongodb.WriteResult;
import com.hiddenfounders.entity.DislikedShop;
import com.hiddenfounders.entity.Shop;
import com.hiddenfounders.entity.Shop_time;
import com.hiddenfounders.repository.DislikedShopRepository;

@Service
public class DislikedShopServiceImpl implements DislikedShopService {
	private DislikedShopRepository DislikedShopRepository;

	@Autowired
	public DislikedShopServiceImpl(DislikedShopRepository DislikedShopRepository) {
		this.DislikedShopRepository = DislikedShopRepository;
	}

	@Autowired
	MongoTemplate mongoTemplate;

	@Override
	public DislikedShop findAllLikedUsername(String username) {
		// TODO Auto-generated method stub
		return DislikedShopRepository.findByUsernameLike(username);
	}

	@Override
	public void addDisliked(String user, String shop) {
		Query query = new Query(Criteria.where("name").is(shop));
		Update update = new Update();
		update.push("disliked", new Shop_time(user, (long) System.currentTimeMillis() + 20000));
		System.out.println(System.currentTimeMillis());
		mongoTemplate.updateFirst(query, update, Shop.class);
		System.out.println("updated");
	}

	@Override
	public void removeDisliked(String idUser) {
		System.out.println(System.currentTimeMillis());
		Query query = new Query(Criteria.where("disliked.timestamp").lt(System.currentTimeMillis()));
		Update update = new Update();
		update.pull("disliked", new Shop_time(idUser));
		mongoTemplate.updateMulti(query, update, Shop.class);

	}
}
