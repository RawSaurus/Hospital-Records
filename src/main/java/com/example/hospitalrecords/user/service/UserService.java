package com.example.hospitalrecords.user.service;

import com.example.hospitalrecords.user.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

//    todo and here?
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }
}
