package com.hiddenfounders.entity;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class DislikedShop {

	@Id
	String id;
	String username;

	List<Shop_time> shops;

	public List<Shop_time> getShops() {
		return shops;
	}

	public void DislikedShopsetShops(List<Shop_time> shops) {
		this.shops = shops;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
