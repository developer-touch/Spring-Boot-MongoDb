package com.ankit.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ankit.entity.Product;

public interface ProductRepository extends MongoRepository<Product, String>{
	
}
