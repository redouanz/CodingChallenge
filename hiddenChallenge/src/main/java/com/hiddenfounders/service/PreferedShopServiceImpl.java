package com.hiddenfounders.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.hiddenfounders.dto.ShopDto;
import com.hiddenfounders.entity.Shop;
import com.hiddenfounders.mapper.ShopMapper;
import com.hiddenfounders.repository.ShopRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class PreferedShopServiceImpl implements PreferedShopService {

	@Autowired
	MongoTemplate mongoTemplate;

	@Autowired
	ShopService shopService;

	private ShopRepository ShopRepository;

	@Autowired
	public PreferedShopServiceImpl(ShopRepository ShopRepository) {
		this.ShopRepository = ShopRepository;
	}

	@Override
	public ShopDto addPrefered(String user, String shop) {

		Query query = new Query(Criteria.where("name").is(shop));
		Update update = new Update();
		update.push("prefered", user);
		mongoTemplate.updateFirst(query, update, Shop.class);
		ShopDto shopdto = shopService.findByName(shop);
		return shopdto;
	}

	@Override
	public ShopDto removePrefered(String user, String shop) {
		Query query = new Query(Criteria.where("name").is(shop));
		Update update = new Update();
		update.pull("prefered", user);
		mongoTemplate.updateFirst(query, update, Shop.class);
		ShopDto shopdto = shopService.findByName(shop);
		return shopdto;
	}

	@Override
	public List<ShopDto> findAllLikedrShop(String username, float lon, float lat) {
		List<Shop> shops = ShopRepository.findNearPreferedShop(username, lon, lat);
		List<ShopDto> shopsDto = new ArrayList<>();
		for (Shop shop : shops) {
			shopsDto.add(ShopMapper.shopToShopDto(shop));
		}
		return shopsDto;
	}

}
