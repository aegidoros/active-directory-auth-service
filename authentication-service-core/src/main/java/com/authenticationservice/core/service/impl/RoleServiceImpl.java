package com.authenticationservice.core.service.impl;

import com.authenticationservice.core.mapper.RoleMapper;
import com.authenticationservice.core.service.RoleService;
import com.authenticationservice.db.entity.RoleEntity;
import com.authenticationservice.db.repository.RoleRepository;
import com.authenticationservice.dto.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;
    private final RoleMapper roleMapper = RoleMapper.INSTANCE;

    @Autowired
    public RoleServiceImpl(RoleRepository repository) {
        this.roleRepository = repository;
    }

    @Override
    public List<Role> getAll() {
        ArrayList<RoleEntity> roleEntities = (ArrayList<RoleEntity>) roleRepository.findAll();
        return roleEntities.stream().map(RoleEntity -> roleMapper.toDto(RoleEntity))
                .collect(Collectors.toList());
    }

    @Override
    public Role getOne(Long rightId) {
        return roleMapper.toDto(roleRepository.findOne(rightId));
    }
}
