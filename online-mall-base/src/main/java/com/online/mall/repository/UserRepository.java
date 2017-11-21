package com.online.mall.repository;

import com.online.mall.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author mgcele
 */
public interface UserRepository extends MongoRepository<User, Long>{
}
