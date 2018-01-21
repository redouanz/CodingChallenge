package com.hiddenfounders.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.hiddenfounders.entity.Usere;
import com.hiddenfounders.service.UserService;
@Service
public class MyAppUserDetailsService implements UserDetailsService {
	@Autowired
	private UserService  userInfoDAO;
	@Override
	public UserDetails loadUserByUsername(String userName)
			throws UsernameNotFoundException {
		Usere activeUsere = userInfoDAO.findByUsername(userName);
		
		System.out.println("*---------------"+activeUsere.toString());
		GrantedAuthority authority = new SimpleGrantedAuthority("USER");
		UserDetails userDetails = (UserDetails)new User(activeUsere.getUsername(),
				activeUsere.getPassword(), Arrays.asList(authority));
		return userDetails;
	}
}


