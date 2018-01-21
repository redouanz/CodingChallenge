package com.hiddenfounders.service;

import java.util.List;

import com.hiddenfounders.dto.ShopDto;

public interface PreferedShopService {

	public ShopDto removePrefered(String idUser, String idShop);

	public List<ShopDto> findAllLikedrShop(String username, float lon, float lat);

	public ShopDto addPrefered(String Username, String shopPrefered);

}
