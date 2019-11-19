package com.harman.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.harman.entity.CommandEntity;

public interface CommandRepository extends MongoRepository<CommandEntity, String>{

	public CommandEntity findByCommandName();
}
