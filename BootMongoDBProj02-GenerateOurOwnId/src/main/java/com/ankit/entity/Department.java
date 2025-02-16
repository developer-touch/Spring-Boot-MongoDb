package com.ankit.entity;

import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.Id;
import lombok.Data;

@Data
@Document
public class Department {
	@Id
	private Integer id;
	private Integer dno;
	private String name;
	private String addrs;
}
