package com.hiddenfounders.controller;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.hiddenfounders.entity.User;
import com.hiddenfounders.service.UserService;
import javax.naming.AuthenticationException;


@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("api")
public class LoginController {
    @Autowired
    private UserService userService;

   @RequestMapping(value = "/login", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> login(@RequestBody User user) throws AuthenticationException {
        if (StringUtils.isEmpty(user.getUsername()) || StringUtils.isEmpty(user.getPassword())) {
            throw new AuthenticationException("Username and password must be provided");
        }

        if (userService.findByUsername(user.getUsername()) == null || userService.findByPassword(user.getPassword()) == null) {
            throw new AuthenticationException("Invalid username or password");
        }

        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    
   

}
