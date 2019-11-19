package com.harman.repositories;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.harman.Entity.WorkFlowEntity;


public interface WorkFlowRepository extends MongoRepository<WorkFlowEntity, String>{
	
	public WorkFlowEntity findByworkFlowName(String name);
	public Optional<WorkFlowEntity> findByworkFlowId(String id);

}
