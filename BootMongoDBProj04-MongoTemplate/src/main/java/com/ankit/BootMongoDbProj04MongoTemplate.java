package com.ankit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class BootMongoDbProj04MongoTemplate {

	public static void main(String[] args) {
		SpringApplication.run(BootMongoDbProj04MongoTemplate.class, args);
	}

}
