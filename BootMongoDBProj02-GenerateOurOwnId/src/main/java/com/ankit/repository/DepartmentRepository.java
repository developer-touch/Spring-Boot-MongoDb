package com.ankit.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ankit.entity.Department;

public interface DepartmentRepository extends MongoRepository<Department, Integer> {

}
