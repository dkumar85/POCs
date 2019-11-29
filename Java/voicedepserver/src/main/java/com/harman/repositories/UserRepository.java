package com.harman.repositories;


import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.harman.entities.UserEntity;

public interface UserRepository extends MongoRepository<UserEntity, String> {
	
	public Optional<UserEntity> findByEmail(String email);

}
