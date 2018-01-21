package com.hiddenfounders.mapper;

import com.hiddenfounders.dto.ShopDto;
import com.hiddenfounders.entity.Shop;

public class ShopMapper {

	public static ShopDto shopToShopDto(Shop shop) {
		ShopDto shopDto = new ShopDto();
		shopDto.setName(shop.getName());
		shopDto.setPicture(shop.getPicture());
		return shopDto;
	}
}
