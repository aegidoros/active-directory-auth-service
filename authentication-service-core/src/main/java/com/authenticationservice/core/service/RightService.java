package com.authenticationservice.core.service;

import com.authenticationservice.db.entity.UserEntity;
import com.authenticationservice.dto.Right;
import com.authenticationservice.dto.User;

import java.util.List;

public interface RightService {

    List<Right> getAll();

    Right getOne(Long rightId);

    List<Right> findRightsByUser(User user);
}
