package com.task.secureuser.controller;

import com.task.secureuser.model.AllUsers;
import com.task.secureuser.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    @Autowired
    private UserRepo repo;
    @Autowired
    private PasswordEncoder encoder;

    @PostMapping("/register")
    public AllUsers createUser(@RequestBody AllUsers user){
        user.setPassword(encoder.encode(user.getPassword()));
        return repo.save(user);
    }
}
