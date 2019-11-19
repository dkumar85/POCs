package com.example.mongodemo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.example.mongodemo.model.Address;
import com.example.mongodemo.model.Customer;
import com.example.mongodemo.repositories.CustomerRepository;


@SpringBootApplication
@ComponentScan
public class MongoDemoApplication implements CommandLineRunner{

	private static Logger logger = LogManager.getLogger();

	@Autowired
	private CustomerRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(MongoDemoApplication.class, args);
	}
	
	public void	performSomeTask() {
	logger.debug("This is a debug message.");
	logger.info("This is a info message.");
	logger.warn("This is a warn message.");
	logger.error("This is a error message.");
	logger.fatal("This is a fatal message.");
	}
	
	@Override
	public void run(String... args) throws Exception {
		
		
		repository.deleteAll();
		
		//save a couple of customers
		Customer customer1 = new Customer("Dharmendra", "Sharma", 32, new Address(3144, 228, 110035));
		Customer customer2 = new Customer("Addie", "Sharma", 2, new Address(3145, 229, 110036));
		Customer customer3 = new Customer("Priya", "Sharma", 26, new Address(3146, 230, 110037));
		
		repository.save(customer1);
		repository.save(customer2);
		repository.save(customer3);
		
		//fetch all customers
		System.out.println("Customers found with findAll():");
		System.out.println("-------------------------------");
		for (Customer customer : repository.findAll()) {
			System.out.println(customer);
		}
		System.out.println();
		
		//fetch an individual customer
		System.out.println("Customer found by findByFirstName(Dharmendra):");
		System.out.println("------------------------------------");
		System.out.println(repository.findByFirstName("Dharmendra"));
		
		System.out.println("Customer found by findByFirstName(Sharma):");
		System.out.println("------------------------------------");
		for (Customer customer : repository.findByLastName("Sharma")) {
			System.out.println(customer);
		}
		
		System.out.println("Customer found by using Query: @Query(\"{'firstName : ?0'}\")");
		System.out.println("-------------------------------------------------------------");
		System.out.println(repository.myQuery("Addie"));
		performSomeTask();
		
		
	}

	
	
}
