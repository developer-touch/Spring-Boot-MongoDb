package com.ankit.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.ankit.entity.Employee;

public interface EmployeeMgmtRepository extends MongoRepository<Employee, Integer>{
	public List<Employee> findBySalaryBetween(Double start,Double end) throws Exception;
	
	//---------------Projection Query----------------
	
	//@Query(value="{addrs:?0 }",fields="{ id:0,name:1,salary:1}")
	@Query(value="{addrs:?0 }",fields="{ id:1,name:1,salary:1}")
	public List<Object[]> getEmployeeDataByAddress(String addrs) throws Exception;
	
	@Query(value="{addrs:?0 }",fields="{id:0,name:1}")
	public List<Object> getEmployeeNameByAddress(String addrs) throws Exception;
	
	//---------------Entity Query----------------
	
	//@Query(value ="{addrs:?0}",fields="{}")
	@Query(value ="{addrs:?0}")
	public List<Employee> getAllEmployeeDetailsByAddrs(String addrs) throws Exception;
	
	@Query(value ="{addrs:?0,name:?1}")
	public List<Employee> getAllEmployeeDetailsByAddrsAndName(String addrs,String name) throws Exception;
	
	//@Query(value ="{salary{$gte:?0,$lte:?1}}")
	@Query(value ="{salary{$gte:?0},salary{$lte:?1}}")
	public List<Employee> getAllEmployeeDetailsBasedOnSalary(Double start,Double end) throws Exception;
	
	@Query(value = "{$or:[{addrs:?0},{addrs:?1}]}")
	public List<Employee> getAllEmployeeDataByAddress(String addrs1,String addrs2) throws Exception;
}
