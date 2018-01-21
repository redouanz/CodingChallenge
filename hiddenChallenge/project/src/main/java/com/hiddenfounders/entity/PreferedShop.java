package com.hiddenfounders.entity;

import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class PreferedShop {

	@Id
	String id;
	String username;
	List<String> shops;

	public PreferedShop(String username, String shops) {
		this.username=username;
		this.shops.add(shops);
		}

	public PreferedShop() {
		// TODO Auto-generated constructor stub
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

	public List<String> getShops() {
		return shops;
	}

	public void setShops(List<String> shops) {
		this.shops = shops;
	}

}
