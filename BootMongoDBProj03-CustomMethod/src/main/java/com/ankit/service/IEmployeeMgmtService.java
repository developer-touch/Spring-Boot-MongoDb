package com.ankit.service;

import java.util.List;

import com.ankit.entity.Employee;

public interface IEmployeeMgmtService {
	public String registerEmployee(Employee employee) throws Exception;
	public String registerBatchEmployee(List<Employee> empList) throws Exception;
	public List<Employee> getEmployeeBySalaryRange(Double start,Double end) throws Exception;
	public List<Object[]> getEmployeeDataByAddress(String addrs) throws Exception;
	public List<Object> getEmployeeNameByAddress(String addrs) throws Exception;
	public List<Employee> getAllEmployeeDetailsByAddrs(String addrs) throws Exception;
	public List<Employee> getAllEmployeeDetailsByAddrsAndName(String addrs,String name) throws Exception;
	public List<Employee> getAllEmployeeDetailsBasedOnSalary(Double start,Double end) throws Exception;
	public List<Employee> getAllEmployeeDataByAddress(String addrs1,String addrs2) throws Exception;
}
