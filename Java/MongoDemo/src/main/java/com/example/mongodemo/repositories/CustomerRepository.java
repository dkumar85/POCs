package com.example.mongodemo.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.example.mongodemo.model.Customer;


public interface CustomerRepository extends MongoRepository<Customer, String>{
	
	
	public Customer findByFirstName(String firstName);
	public List<Customer> findByLastName(String lastName);
	
	@Query("{'firstName' : ?0}")
	public Customer myQuery(String firstName);

}
