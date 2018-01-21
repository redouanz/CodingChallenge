package com.hiddenfounders.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hiddenfounders.entity.Usere;
import com.hiddenfounders.repository.UserRepository;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
	private UserRepository userRepository;

	@Autowired
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	

	@Override
	public List<Usere> getUsers() {
		return userRepository.findAll();
	}

	@Override
	public Usere createUser(Usere user) {
		Usere savedUser = userRepository.save(user);

		System.out.println(savedUser.toString());
		return savedUser;
	}

	@Override
	public Usere findByUsername(String username) {
		return userRepository.findByUsername(username);
	}

	@Override
	public Usere findByPassword(String password) {
		return userRepository.findByPassword(password);
	}

}
