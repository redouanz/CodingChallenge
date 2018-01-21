package com.hiddenfounders.entity;

public class LikedShopTime {

	private Long timestamp;

	private String username;

	public LikedShopTime(String string, Long l) {
		username = string;
		timestamp = l;
	}

	public LikedShopTime() {

	}

	public LikedShopTime(String username) {
		this.username = username;

	}

	public Long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}

	public String getShop() {
		return username;
	}

	public void setShop(String username) {
		this.username = username;
	}

}