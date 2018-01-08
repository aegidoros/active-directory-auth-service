package com.authenticationservice.core.mapper;

import com.authenticationservice.db.entity.RoleEntity;
import com.authenticationservice.dto.Role;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface RoleMapper extends IEntityDTOMapper<Role, RoleEntity> {
    RoleMapper INSTANCE = Mappers.getMapper(RoleMapper.class);
}
