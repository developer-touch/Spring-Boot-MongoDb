package com.ankit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ankit.entity.Employee;
import com.ankit.repository.EmployeeMgmtRepository;

@Service
public class EmployeeMgmtServiceImpl implements IEmployeeMgmtService {

	public EmployeeMgmtServiceImpl() {
		System.out.println("EmployeeMgmtServiceImpl::0-param constructor");
	}
	
	//inject repository
	@Autowired
	private EmployeeMgmtRepository empRepo;
	
	@Override
	public String registerEmployee(Employee employee) throws Exception{
		System.out.println("EmployeeMgmtServiceImpl.registerEmployee()");
		//use repository
		Integer idValue = empRepo.save(employee).getId();
		return idValue+" employee is registered...";
	}
	
	@Override
	public String registerBatchEmployee(List<Employee> empList) throws Exception {
		System.out.println("EmployeeMgmtServiceImpl.registerBatchEmployee()");
		//use repository
		Integer empCount = empRepo.saveAll(empList).size();
		return "No.of employees register "+empCount;
	}
	
	@Override
	public List<Employee> getEmployeeBySalaryRange(Double start, Double end) throws Exception {
		System.out.println("EmployeeMgmtServiceImpl.getEmployeeBySalaryRange()");
		//use repository
		return empRepo.findBySalaryBetween(start, end);
	}

	@Override
	public List<Object[]> getEmployeeDataByAddress(String addrs) throws Exception {
		System.out.println("EmployeeMgmtServiceImpl.getEmployeeDataByAddress()");
		//use repository
		return empRepo.getEmployeeDataByAddress(addrs);
	}

	@Override
	public List<Object> getEmployeeNameByAddress(String addrs) throws Exception {
		System.out.println("EmployeeMgmtServiceImpl.getEmployeeNameByAddress()");
		//use repository
		return empRepo.getEmployeeNameByAddress(addrs);
	}
	
	@Override
	public List<Employee> getAllEmployeeDetailsByAddrs(String addrs) throws Exception {
		System.out.println("EmployeeMgmtServiceImpl.getAllEmployeeDetailsByName()");
		return empRepo.getAllEmployeeDetailsByAddrs(addrs);
	}
	
	@Override
	public List<Employee> getAllEmployeeDetailsByAddrsAndName(String addrs,String name) throws Exception {
		System.out.println("EmployeeMgmtServiceImpl.getAllEmployeeDetailsByAddrsAndName()");
		return empRepo.getAllEmployeeDetailsByAddrsAndName(addrs,name);
	}
	
	@Override
	public List<Employee> getAllEmployeeDetailsBasedOnSalary(Double start, Double end) throws Exception {
		System.out.println("EmployeeMgmtServiceImpl.getAllEmployeeDetailsBasedOnSalary()");
		return empRepo.getAllEmployeeDetailsBasedOnSalary(start, end);
	}
	
	@Override
	public List<Employee> getAllEmployeeDataByAddress(String addrs1, String addrs2) throws Exception {
		System.out.println("EmployeeMgmtServiceImpl.getAllEmployeeDataByAddress()");
		return empRepo.getAllEmployeeDataByAddress(addrs1, addrs2);
	}
}
