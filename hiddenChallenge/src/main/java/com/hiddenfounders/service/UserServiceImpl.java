package com.hiddenfounders.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hiddenfounders.entity.User;
import com.hiddenfounders.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	private UserRepository userRepository;

	@Autowired
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public User createUser(User user) {
		User savedUser = userRepository.save(user);

		System.out.println(savedUser.toString());
		return savedUser;
	}

	@Override
	public User findByUsername(String username) {
		return userRepository.findByUsername(username);
	}

	@Override
	public User findByPassword(String password) {
		return userRepository.findByPassword(password);
	}

}
