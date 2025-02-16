package com.ankit.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ankit.entity.Department;
import com.ankit.repository.DepartmentRepository;

@Service("deptService")
public class DepartmentServiceImpl implements IDepartmentService {
	
	public DepartmentServiceImpl() {
		System.out.println("DepartmentServiceImpl::0-param constructor");
	}
	
	//inject department repository 
	@Autowired
	private DepartmentRepository deptRepo;
	
	@Override
	public String registerDepartment(Department dept) {
		System.out.println("DepartmentServiceImpl.registerDepartment()");
		//use repository
		int dnoVal = deptRepo.insert(dept).getId();
		return "Department records is saved with dno :: "+dnoVal;
	}
	
	@Override
	public String registerMultipleDepartment(List<Department> deptList) {
		System.out.println("DepartmentServiceImpl.registerMultipleDepartment()");
		//use repository
		int deptSize = deptRepo.saveAll(deptList).size();
		return "no.of department is inserted "+deptSize;
	}
	
	@Override
	public String findDepartmentById(Integer id) {
		System.out.println("DepartmentServiceImpl.findDepartmentById()");
		//use repository
		Optional<Department> deptId = deptRepo.findById(id);
		if(deptId.isEmpty()) {
			return "Department not found bcz id is invalid ";
		}
		return deptId.get().toString();
	}
}
