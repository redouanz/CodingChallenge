package com.hiddenfounders.service;




import com.hiddenfounders.entity.User;

public interface UserService {
    
	User createUser(User user);
    User findByUsername(String username);
    User findByPassword(String password);

	
}
