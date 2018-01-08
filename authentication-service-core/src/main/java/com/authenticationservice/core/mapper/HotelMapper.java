package com.authenticationservice.core.mapper;

import com.authenticationservice.db.entity.HotelEntity;
import com.authenticationservice.dto.HotelDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


/**
 * <p>
 * <p>
 * <p>
 * <p>
 * @author cjrequena
 * @version 1.0
 * @since JDK1.8
 * @see
 *
 */
@Mapper
public interface HotelMapper extends IEntityDTOMapper<HotelDTO, HotelEntity> { //NOSONAR

  HotelMapper INSTANCE = Mappers.getMapper(HotelMapper.class);

}
