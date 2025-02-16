package com.ankit.entity;

import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Document
@AllArgsConstructor
@RequiredArgsConstructor
public class Employee {
	@Id
	private Integer id;
	private String name;
	private String desg;
	private String addrs;
	private Double salary;
	private Integer dept;
}
