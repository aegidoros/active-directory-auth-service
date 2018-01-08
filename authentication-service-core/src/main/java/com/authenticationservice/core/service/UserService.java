package com.authenticationservice.core.service;

import com.authenticationservice.dto.User;

public interface UserService {

   User findByName(String name);
   User findByEmail(String email);

}
