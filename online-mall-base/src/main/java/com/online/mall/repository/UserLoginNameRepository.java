package com.online.mall.repository;

import com.online.mall.model.UserLoginName;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author mgcele
 */
public interface UserLoginNameRepository extends MongoRepository<UserLoginName, Long>{
}
