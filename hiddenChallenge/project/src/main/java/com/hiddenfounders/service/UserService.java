package com.hiddenfounders.service;



import java.util.List;

import com.hiddenfounders.entity.Usere;

public interface UserService {
    List<Usere> getUsers();
    
    Usere createUser(Usere user);
    Usere findByUsername(String username);
    Usere findByPassword(String password);

	
}
