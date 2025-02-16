package com.ankit.service;

import java.util.List;

import com.ankit.entity.Department;

public interface IDepartmentService {
	public String registerDepartment(Department dept);
	public String registerMultipleDepartment(List<Department> deptList);
	public String findDepartmentById(Integer id);
}
