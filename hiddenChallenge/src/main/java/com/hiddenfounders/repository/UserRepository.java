package com.hiddenfounders.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.hiddenfounders.entity.User;

public interface UserRepository extends MongoRepository<User, String> {
	
	User findByUsername(String email);

	User findByPassword(String password);
}
