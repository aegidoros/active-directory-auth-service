package com.authenticationservice.core.mapper;

import com.authenticationservice.db.entity.UserEntity;
import com.authenticationservice.dto.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper extends IEntityDTOMapper<User, UserEntity> {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
}
