package com.hiddenfounders.controller;


import com.hiddenfounders.repository.ShopRepository;
import com.hiddenfounders.service.DislikedShopService;
import com.hiddenfounders.service.ShopService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("shop")
public class ShopController {

	
	@Autowired
	ShopService shopService;

	@Autowired
	DislikedShopService dislikedShopService;

	@RequestMapping(value = "/nearetShop", method = RequestMethod.POST)
	public ResponseEntity<?> dislike(@RequestParam String user, @RequestParam float lon, @RequestParam float lat) {
		dislikedShopService.removeDisliked(user);
		return new ResponseEntity<>(shopService.findNearShop(user, lon, lat), HttpStatus.OK);
	}

}