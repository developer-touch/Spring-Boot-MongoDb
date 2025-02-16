package com.ankit.runners;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.ankit.entity.Department;
import com.ankit.service.IDepartmentService;

@Component
public class DepartmentOurIdGenertorRunners implements CommandLineRunner {

	//inject the DepartmentService
	@Autowired
	private IDepartmentService deptService;
	
	@Override
	public void run(String... args) throws Exception {
		System.out.println("DepartmentOurIdGenertorRunners.run()");
		
		/*try {
			//create Department object and set the required value 
			Department dept = new Department();
			dept.setId(new Random().nextInt(100)); dept.setDno(10);
			dept.setName("Analyst"); dept.setAddrs("Hyd");
			//invoke the method
			String savedDept = deptService.registerDepartment(dept);
			System.out.println(savedDept);
		}
		catch (Exception e) {
			e.printStackTrace();
		}*/
		
		try {
			//create Department object and set the required value 
			Department dept1 = new Department();
			dept1.setId(new Random().nextInt(100)); dept1.setDno(20);
			dept1.setName("Salesman"); dept1.setAddrs("Hyd");
			Department dept2 = new Department();
			dept2.setId(new Random().nextInt(100)); dept2.setDno(10);
			dept2.setName("Analyst"); dept2.setAddrs("Hyd");
			Department dept3 = new Department();
			dept3.setId(new Random().nextInt(100)); dept3.setDno(20);
			dept3.setName("Manager"); dept3.setAddrs("Mp");
			//invoke the method
			String savedDept = deptService.registerMultipleDepartment(List.of(dept1,dept2,dept3));
			System.out.println(savedDept);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		/*try {
			//invoke the method
			String msg = deptService.findDepartmentById(78);
			System.out.println(msg);
		}
		catch (Exception e) {
			e.printStackTrace();
		}*/
	}

}
