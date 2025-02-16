package com.ankit.entity;

import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.Id;
import lombok.Data;

@Document
@Data
public class Product {
	@Id
	private String id;
	private String name;
	private String type;
	private Double price;
	private Integer qnty;
	private String rating;
	private String[] props;
	private String warranty;
}
