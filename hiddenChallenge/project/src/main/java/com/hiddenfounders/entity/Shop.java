package com.hiddenfounders.entity;

import java.util.List;

import org.springframework.data.annotation.Id;

import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Shop {

	@Id
	String id;
	String name;
	String email;
	String city;
	List<String> preferd;
	List<Shop_time> disliked;

	public List<Shop_time> getDisliked() {
		return disliked;
	}

	public void setDisliked(List<Shop_time> disliked) {
		this.disliked = disliked;
	}

	public List<String> getPreferd() {
		return preferd;
	}

	public void setPreferd(List<String> preferd) {
		this.preferd = preferd;
	}

	private GeoJsonPoint location;

	public GeoJsonPoint getLocation() {
		return location;
	}

	public void setLocation(GeoJsonPoint location) {
		this.location = location;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

}
