package com.hiddenfounders.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hiddenfounders.dto.ShopDto;
import com.hiddenfounders.entity.Shop;

import com.hiddenfounders.repository.ShopRepository;
import com.hiddenfounders.service.*;

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
public class PreferdShopController {

	@Autowired
	PreferedShopService PreferedShopService;

	@RequestMapping(value = "/add_perfered", method = RequestMethod.POST)
	public ResponseEntity<?> addPreferd(@RequestParam String user, @RequestParam String shop) {
		ShopDto shopDto=PreferedShopService.addPrefered(user,shop);
		
		return new ResponseEntity<>(shopDto ,HttpStatus.OK);
	}

	@RequestMapping(value = "/get_perfered", method = RequestMethod.POST)
	public ResponseEntity<?> getPreferd(@RequestParam String user, @RequestParam float lat ,@RequestParam float lon) {
		List <ShopDto> l=PreferedShopService.findAllLikedrShop(user,lon,lat);
		return new ResponseEntity<>(l ,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/remove_perfered", method = RequestMethod.POST)
	public ResponseEntity<?> removePreferd(@RequestParam String user, @RequestParam String shop) {
		ShopDto shopDto=PreferedShopService.removePrefered(user, shop);
		return new ResponseEntity<>(shopDto ,HttpStatus.OK);
	}
}
	