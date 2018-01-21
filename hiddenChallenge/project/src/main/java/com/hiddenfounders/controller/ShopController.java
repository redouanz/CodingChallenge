package com.hiddenfounders.controller;


import java.util.HashMap;

import java.util.Map;

import com.hiddenfounders.entity.Shop;

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

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("shop")
public class ShopController {
 
 @Autowired
 ShopRepository ShopRepository;
@Autowired
 DislikedShopService ds;



 @RequestMapping(value="/nearetShop", method = RequestMethod.POST)
 public ResponseEntity<?> dislike(@RequestParam String user,@RequestParam float lon,@RequestParam float  lat) {
	 ds.removeDisliked(user);
 System.out.println("authentifi user 2");
	 
	return new ResponseEntity<>(ShopRepository.findNearShop(user,lon,lat), HttpStatus.OK);
 }
 
 


 

 
 @RequestMapping("/add_like")
 public Map<String, Object> updateLiked(@RequestParam String ShopId) {
	  Shop Shop = ShopRepository.findOne(ShopId);
	   
	  System.out.println(Shop);
	  Shop = ShopRepository.save(Shop);
	  Map<String, Object> dataMap = new HashMap<String, Object>();
	  dataMap.put("message", "Shop updated successfully");
	  dataMap.put("status", "1");
	  dataMap.put("Shop", Shop);
	     return dataMap;
}
 
 @RequestMapping("/remove_like")
 public Map<String, Object> updatedisLiked(@RequestParam String ShopId) {
	  Shop Shop = ShopRepository.findOne(ShopId);
	  System.out.println(Shop);
	  Shop = ShopRepository.save(Shop);
	  Map<String, Object> dataMap = new HashMap<String, Object>();
	  dataMap.put("message", "Shop updated successfully");
	  dataMap.put("status", "1");
	  dataMap.put("Shop", Shop);
	  return dataMap;
	 }
 
 


}