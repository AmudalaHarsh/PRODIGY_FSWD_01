package com.task.secureuser.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

    @GetMapping("/")
    public String getHome(){
        return "home";
    }

    @GetMapping("/admin")
    public String getAdmin(){
        return "admin";
    }

    @GetMapping("/user")
    public String getUser(){
        return "user";
    }

    @GetMapping("/login")
    public String getLogin(){
        return "login";
    }
}