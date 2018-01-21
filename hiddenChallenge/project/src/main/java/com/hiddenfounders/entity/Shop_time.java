package com.hiddenfounders.entity;


public class Shop_time{
	
	private Long timestamp;
	
	private String username;

	public Shop_time(String string, Long l) {
		username=string;
		timestamp=l;
	}


	public Shop_time() {
		
	}


	public Shop_time(String username) {
		this.username=username;
	
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