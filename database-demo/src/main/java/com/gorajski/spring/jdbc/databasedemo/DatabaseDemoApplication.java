package com.gorajski.spring.jdbc.databasedemo;

import com.gorajski.spring.jdbc.databasedemo.entity.Person;
import com.gorajski.spring.jdbc.databasedemo.jdbc.PersonJdbcDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class DatabaseDemoApplication implements CommandLineRunner {		//CommandLineRunner executes the run method once
																		//Spring Context is up and ready.

	private Logger logger = LoggerFactory.getLogger(DatabaseDemoApplication.class);

	@Autowired
	PersonJdbcDAO dao;

	public static void main(String[] args) {
		SpringApplication.run(DatabaseDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("All users -> {}", dao.findAll());
		logger.info("User ID 10001 -> {}", dao.findById(10001));
		logger.info("Deleting ID 10002 -> No of Rows Deleted - {}", dao.deleteById(10002));
		logger.info("Inserting 10004 - {}", dao.insert(new Person(10004, "Tara", "Berlin", new Date())));
		logger.info("Update 10003 ->  {}", dao.update(new Person(10003, "Pieter", "Utrecht", new Date())));
		logger.info("Update Pieter to Piaul -> {}", dao.updateByName( "Pieter", new Person(10003, "Piaul", "Utrecht", new Date())));

	}
}
