package com.hiddenfounders.service;

import com.hiddenfounders.dto.ShopDto;

public interface DislikedShopService {

	public ShopDto addDisliked(String user, String shop);

	public void removeDisliked(String idUser);

}
