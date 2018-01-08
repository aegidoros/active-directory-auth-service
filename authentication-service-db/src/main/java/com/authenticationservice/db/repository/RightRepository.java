package com.authenticationservice.db.repository;

import com.authenticationservice.db.entity.RightEntity;
import com.authenticationservice.db.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RightRepository extends CrudRepository<RightEntity, Long> {

    List<RightEntity> findByUserName (UserEntity user);

}
