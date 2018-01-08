package com.authenticationservice.core.mapper;

import com.authenticationservice.db.entity.RightEntity;
import com.authenticationservice.dto.Right;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface RightMapper extends IEntityDTOMapper<Right, RightEntity> {

    RightMapper INSTANCE = Mappers.getMapper(RightMapper.class);
}
