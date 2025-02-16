package com.ankit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import jakarta.annotation.sql.DataSourceDefinition;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class BootMongoDBProj02GenerateOurOwnId {

	public static void main(String[] args) {
		SpringApplication.run(BootMongoDBProj02GenerateOurOwnId.class, args);
	}

}
