package com.ankit.service;

import java.util.List;

import com.ankit.entity.Doctor;

public interface IDoctorAndEmployeeMgmtService {
	public String registerDoctor(Doctor doctor) throws Exception;
	public String registerBatchDoctor(List<Doctor> doctors) throws Exception;
	public List<Doctor> findDoctorByName(String name) throws Exception;
	public List<Doctor> findDoctorByAddrs(String addrs) throws Exception;
	public Doctor findDoctorById(Integer id) throws Exception;
	public String findAndModifyDoctorByName(Integer id,String newName) throws Exception;
	public String findAndModifyEmplyeeDeptByPriceRange(Integer dept,Double start,Double end) throws Exception;
	public String registerAndUpdateEmployeebyDesg(String desg,String name,String addrs,Double salary,Integer dept) throws Exception;
	public String findAndDeleteEmployeeById(Integer id) throws Exception;
	public String findAndDeleteAllEmployeeBySalaryRenage(Double startRange,Double endRange) throws Exception;
}
