package com.example.hospitalrecords.user.controller;

import com.example.hospitalrecords.user.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    //todo should be something here?
    public UserController(UserService userService){
        this.userService = userService;
    }
}
