        package com.authenticationservice.core.service;

        import com.authenticationservice.db.entity.HotelEntity;
        import com.authenticationservice.exception.ServiceException;
        import java.util.List;


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
public interface HotelService {

  List<HotelEntity> getAll() throws ServiceException;

  HotelEntity getById(Integer hotelId) throws ServiceException;

  boolean exist(HotelEntity hotelEntity) throws ServiceException;

  boolean create(HotelEntity hotelEntity) throws ServiceException;

  boolean update(HotelEntity hotelEntity) throws ServiceException;

  boolean delete(Integer hotelId) throws ServiceException;

}
