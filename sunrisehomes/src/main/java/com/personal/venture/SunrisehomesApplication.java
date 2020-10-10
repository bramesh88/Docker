package com.personal.venture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.personal.venture.bean.User;
import com.personal.venture.repository.UserRepository;

@SpringBootApplication
public class SunrisehomesApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	UserRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(SunrisehomesApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		logger.info("Student id 10001 -> {}", repository.findById(Integer.valueOf(10001)).get().getName());

		logger.info("Inserting -> {}", repository.save(new User("John", "A1234657")).getId());

		logger.info("Update 10003 -> {}", repository.save(new User("Raa", "Name-Updated")).getName());

		repository.deleteById(10002);

		logger.info("All users -> {}", repository.findAll().size());
	}
}
