package com.hiddenfounders.controller;


import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.hiddenfounders.entity.Usere;
import com.hiddenfounders.service.UserService;

@RestController
@CrossOrigin
@RequestMapping("api")
public class RegisterController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/register", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> register(@RequestBody Usere user) {
    	user.setRoles(Arrays.asList("ROLE_USER"));
    	userService.createUser(user);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }
}
