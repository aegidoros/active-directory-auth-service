        package com.authenticationservice.core.service.impl;

        import com.authenticationservice.db.repository.HotelRepository;
        import com.authenticationservice.db.entity.HotelEntity;
        import com.authenticationservice.core.service.HotelService;
        import com.authenticationservice.exception.EErrorCode;
        import com.authenticationservice.exception.ServiceException;

        import lombok.extern.log4j.Log4j2;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.cache.annotation.*;
        import org.springframework.stereotype.Service;

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
@Log4j2
@Service("hotelService")
@CacheConfig(cacheNames = "CAFFEINE_CACHE_1")
public class HotelServiceImpl implements HotelService {

  private static final String KEY_ALL = "'HOTELS-*'";

  @Autowired
  HotelRepository hotelRepository;

  @Override
  @Cacheable(key = KEY_ALL)
  public List<HotelEntity> getAll() throws ServiceException {
    try {
      return hotelRepository.findAll();
    } catch (Exception ex) {
      log.warn("{}", ex);
      throw new ServiceException(EErrorCode.UNKNOWN_ERROR.getErrorCode(), ex);
    }
  }

  @Override
  @Cacheable(key = "#hotelId")
  public HotelEntity getById(Integer hotelId) throws ServiceException {
    try {
      return hotelRepository.findById(hotelId);
    } catch (Exception ex) {
      log.warn("{}", ex);
      throw new ServiceException(EErrorCode.UNKNOWN_ERROR.getErrorCode(), ex);
    }
  }

  @Override
  public boolean exist(HotelEntity hotelEntity) throws ServiceException {
    try {
      return hotelRepository.exists(hotelEntity.getHotelId());
    } catch (Exception ex) {
      log.warn("{}", ex);
      throw new ServiceException(EErrorCode.UNKNOWN_ERROR.getErrorCode(), ex);
    }
  }

  @Override
  @CachePut(key = "#hotelEntity.hotelId")
  @Caching(evict = {@CacheEvict(key = KEY_ALL)})
  public boolean create(HotelEntity hotelEntity) throws ServiceException {
    try {
      return hotelRepository.insert(hotelEntity) == 1;
    } catch (Exception ex) {
      log.warn("{}", ex);
      throw new ServiceException(EErrorCode.UNKNOWN_ERROR.getErrorCode(), ex);
    }
  }

  @Override
  @Caching(evict = {@CacheEvict(key = KEY_ALL)}, put = {@CachePut(key = "#hotelEntity.hotelId")})
  public boolean update(HotelEntity hotelEntity) throws ServiceException {
    return hotelRepository.update(hotelEntity) == 1;
  }


  @Override
  @Caching(evict = {@CacheEvict(key = KEY_ALL)}, put = {@CachePut(key = "#hotelId")})
  public boolean delete(Integer hotelId) throws ServiceException {
    try {
      return hotelRepository.delete(hotelId) == 1;
    } catch (Exception ex) {
      log.warn("{}", ex);
      throw new ServiceException(EErrorCode.UNKNOWN_ERROR.getErrorCode(), ex);
    }
  }


}
