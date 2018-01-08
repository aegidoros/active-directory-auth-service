package com.authenticationservice.core.service.impl;

import com.authenticationservice.core.mapper.RightMapper;
import com.authenticationservice.core.mapper.UserMapper;
import com.authenticationservice.core.service.RightService;
import com.authenticationservice.db.entity.RightEntity;
import com.authenticationservice.db.repository.RightRepository;
import com.authenticationservice.dto.Right;
import com.authenticationservice.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
@Service
public class RightServiceImpl implements RightService {

    private final RightRepository rightRepository;
    private final RightMapper rightMapper = RightMapper.INSTANCE;
    private final UserMapper userMapper = UserMapper.INSTANCE;

    @Autowired
    public RightServiceImpl(RightRepository rightRepository) {
        this.rightRepository = rightRepository;
    }

    @Override
    public List<Right> getAll() {
        ArrayList<RightEntity> rightEntities = (ArrayList<RightEntity>) rightRepository.findAll();
        return rightEntities.stream().map(RightEntity -> rightMapper.toDto(RightEntity))
                .collect(Collectors.toList());
    }

    @Override
    public Right getOne(Long rightId) {
        return rightMapper.toDto(rightRepository.findOne(rightId));
    }

    @Override
    public List<Right> findRightsByUser(User user) {
        ArrayList<RightEntity> rightEntities = (ArrayList<RightEntity>) rightRepository
                .findByUserName(userMapper.toEntity(user));

        return rightEntities.stream().map(RightEntity -> rightMapper.toDto(RightEntity)).collect(Collectors.toList());
    }
}
