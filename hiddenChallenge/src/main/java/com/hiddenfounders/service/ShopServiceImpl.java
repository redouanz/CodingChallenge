package com.hiddenfounders.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hiddenfounders.dto.ShopDto;
import com.hiddenfounders.entity.Shop;
import com.hiddenfounders.mapper.ShopMapper;
import com.hiddenfounders.repository.ShopRepository;

@Service
public class ShopServiceImpl implements ShopService {

	 @Autowired
	 ShopRepository ShopRepository;
	 
	@Override
	public ShopDto findByName(String name) {
		Shop shop =ShopRepository.findByName(name);
		return ShopMapper.shopToShopDto(shop);
	}

	@Override
	public List<ShopDto> findNearShop(String user, float lon, float lat) {
		List<Shop> shops =ShopRepository.findNearShop(user, lon, lat);
		List<ShopDto> shopsDto=new ArrayList<>();
		for (Shop shop : shops) {
			shopsDto.add(ShopMapper.shopToShopDto(shop));
		}
		return shopsDto;
	}

	@Override
	public List<ShopDto> findNearPreferedShop(String c, float lon, float lat) {
		List<Shop> shops =ShopRepository.findNearPreferedShop(c, lon, lat);
		List<ShopDto> shopsDto=new ArrayList<>();
		for (Shop shop : shops) {
			shopsDto.add(ShopMapper.shopToShopDto(shop));
		}
		return shopsDto;
	}
	

}
