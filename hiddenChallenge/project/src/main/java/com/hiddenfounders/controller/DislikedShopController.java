
package com.hiddenfounders.controller;

import java.util.HashMap;

import java.util.Map;

import com.hiddenfounders.entity.DislikedShop;

import com.hiddenfounders.repository.ShopRepository;
import com.hiddenfounders.service.DislikedShopService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("shop")

@RestController

public class DislikedShopController {

	@Autowired
	ShopRepository DislikedShopRepository;

	@Autowired
	DislikedShopService DislikeShopService;

	@RequestMapping(value = "/add_disliked", method = RequestMethod.POST)
	public ResponseEntity<?> dislike(@RequestParam String user, @RequestParam String shop) {

		DislikeShopService.addDisliked(user, shop);
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("message", "Shop updated successfully");
		dataMap.put("status", "1");
		return new ResponseEntity<>(dataMap, HttpStatus.OK);
	}

	@RequestMapping(value = "/remove_dislike", method = RequestMethod.POST)
	public Map<String, Object> removee(@RequestParam String useer) {
		DislikeShopService.removeDisliked(useer);
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("message", "Shop updated successfully");
		dataMap.put("status", "1");
		return dataMap;
	}

	@RequestMapping(value = "/get_dislike", method = RequestMethod.POST)
	public Map<String, Object> remove(@RequestParam String useer) {
		DislikedShop d = DislikeShopService.findAllLikedUsername(useer);
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("perfered", d);
		dataMap.put("message", "Shop updated successfully");
		dataMap.put("status", "1");

		return dataMap;
	}

}