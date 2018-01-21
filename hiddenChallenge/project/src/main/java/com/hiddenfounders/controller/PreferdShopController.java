package com.hiddenfounders.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hiddenfounders.entity.PreferedShop;
import com.hiddenfounders.entity.Shop;
import com.hiddenfounders.entity.Usere;
import com.hiddenfounders.repository.ShopRepository;
import com.hiddenfounders.service.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.Point;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @author Dinesh.Rajput
 *
 */
@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("shop")
public class PreferdShopController {

	@Autowired
	ShopRepository ShopRepository;

	@Autowired
	PreferedShopService PreferedShopService;

	@RequestMapping(value = "/add_perfered", method = RequestMethod.POST)
	public Map<String, Object> dislike(@RequestParam String user, @RequestParam String shop) {
		PreferedShopService.addPrefered(user,shop);
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("message", "Shop updated successfully");
		dataMap.put("status", "1");
		return dataMap;
	}

	@RequestMapping(value = "/get_perfered", method = RequestMethod.POST)
	public ResponseEntity<?> dislikef(@RequestParam String user, @RequestParam float lat ,@RequestParam float lon) {
		List <Shop> l=PreferedShopService.findAllLikedrShop(user,lon,lat);
		return new ResponseEntity<>(l ,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/remove_perfered", method = RequestMethod.POST)
	public ResponseEntity<?>remove(@RequestParam String user, @RequestParam String shop) {
		PreferedShopService.removePrefered(user, shop);
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("message", "Shop supprime successfully");
		dataMap.put("status", "1");
		return new ResponseEntity<>(dataMap ,HttpStatus.OK);
	}
}
	