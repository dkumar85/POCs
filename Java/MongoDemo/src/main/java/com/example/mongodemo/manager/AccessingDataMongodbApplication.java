package com.example.mongodemo.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.mongodemo.repositories.CustomerRepository;



@SpringBootApplication
public class AccessingDataMongodbApplication {

	@Autowired
	private CustomerRepository repository;
	
	
}
