package com.hiddenfounders.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.hiddenfounders.entity.User;
import com.hiddenfounders.service.UserService;
@Service
public class MyAppUserDetailsService implements UserDetailsService {
	@Autowired
	private UserService  user;
	@Override
	public UserDetails loadUserByUsername(String userName)
			throws UsernameNotFoundException {
		User activeUsere = user.findByUsername(userName);
		
		GrantedAuthority authority = new SimpleGrantedAuthority("USER");
		UserDetails userDetails = (UserDetails)new org.springframework.security.core.userdetails.User(activeUsere.getUsername(),
				activeUsere.getPassword(), Arrays.asList(authority));
		return userDetails;
	}
}


