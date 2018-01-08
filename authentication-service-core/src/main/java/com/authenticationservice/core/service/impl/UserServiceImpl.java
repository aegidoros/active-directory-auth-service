package com.authenticationservice.core.service.impl;

import com.authenticationservice.core.mapper.UserMapper;
import com.authenticationservice.core.service.UserService;
import com.authenticationservice.db.repository.UserRepository;
import com.authenticationservice.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private final UserMapper userMapper= UserMapper.INSTANCE;

    @Autowired
    public UserServiceImpl(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    @Override
    public User findByName(String name) {
        return userMapper.toDto(userRepository.findByUserName(name));
    }

    @Override
    public User findByEmail(String email) {
        return userMapper.toDto(userRepository.findByEmail(email));
    }
}
