package com.gorajski.spring.jdbc.databasedemo;

import com.gorajski.spring.jdbc.databasedemo.entity.Person;
import com.gorajski.spring.jdbc.databasedemo.jpa.PersonJpaRepository;
import com.gorajski.spring.jdbc.databasedemo.springdata.PersonSpringDataRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class SpringDataDemoApplication implements CommandLineRunner {		//CommandLineRunner executes the run method once
																		//Spring Context is up and ready.

	private Logger logger = LoggerFactory.getLogger(SpringDataDemoApplication.class);

	@Autowired
	PersonSpringDataRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(SpringDataDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("User ID 10001 -> {}", repository.findById(10001));

		//Since this record needs to be generated, JPA will create an ID for this user and therefore one does not need to be passed in.
		logger.info("Inserting - {}", repository.save(new Person("Tara", "Berlin", new Date())));
		logger.info("Inserting - {}", repository.save(new Person("Tara", "Kyoto", new Date())));

		logger.info("Update 10003 ->  {}", repository.save(new Person(10003, "Pieter", "Utrecht", new Date())));

		repository.deleteById(10002);
		logger.info("All users -> {}", repository.findAll());

	}
}
