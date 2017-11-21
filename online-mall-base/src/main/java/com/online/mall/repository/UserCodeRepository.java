package com.online.mall.repository;

import com.online.mall.model.UserCode;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author mgcele
 */
public interface UserCodeRepository extends MongoRepository<UserCode, Long>{
}
