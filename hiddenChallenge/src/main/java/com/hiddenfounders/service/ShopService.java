package com.hiddenfounders.service;

import java.util.List;

import com.hiddenfounders.dto.ShopDto;

public interface ShopService {

	public ShopDto findByName(String name);

	public List<ShopDto> findNearShop(String user, float lon, float lat);

	public List<ShopDto> findNearPreferedShop(String c, float lon, float lat);

}
