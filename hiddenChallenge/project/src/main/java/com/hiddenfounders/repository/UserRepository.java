package com.hiddenfounders.repository;



import org.springframework.data.mongodb.repository.MongoRepository;

import com.hiddenfounders.entity.Usere;

public interface UserRepository extends MongoRepository<Usere, String> {
    Usere findByUsername(String username);
    Usere findByPassword(String password);
}
