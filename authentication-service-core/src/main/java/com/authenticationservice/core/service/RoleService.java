package com.authenticationservice.core.service;

import com.authenticationservice.dto.Role;

import java.util.List;

public interface RoleService {

    List<Role> getAll ();
    Role getOne(Long rightId);
}
