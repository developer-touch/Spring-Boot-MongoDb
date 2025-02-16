package com.ankit.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.ankit.service.IEmployeeMgmtService;

@Component
public class EmployeeMgmtRunner implements CommandLineRunner {

	public EmployeeMgmtRunner() {
		System.out.println("EmployeeMgmtRunner::0-param constructor");
	}
	
	//inject service
	@Autowired
	private IEmployeeMgmtService empService;
	
	@Override
	public void run(String... args) throws Exception {
		System.out.println("EmployeeMgmtRunner.run()");
		
		/*try {
			//use service
			String resultMsg = empService.registerEmployee(new Employee(new Random().nextInt(1000), 
														  "Mahesh", "Manager", "Delhi", 95500.0, 20));
			System.out.println(resultMsg);
		}
		catch (Exception e) {
			System.out.println("Internal problem :: "+e.getMessage());
		}*/
		
		/*try {
			//create employee object
			Employee emp1 = new Employee(new Random().nextInt(1000), 
					  "John", "Salesman", "Hyd", 9500.0, 10);
			Employee emp2 = new Employee(new Random().nextInt(1000), 
					  "Rajesh", "Clerk", "Delhi", 5500.0, 10);
			Employee emp3 = new Employee(new Random().nextInt(1000), 
					  "Ramesh", "Manager", "MP", 95500.0, 10);
			Employee emp4 = new Employee(new Random().nextInt(1000), 
					  "Jitesh", "Clerk", "MM", 9500.0, 20);
			Employee emp5 = new Employee(new Random().nextInt(1000), 
					  "Ganesh", "Salesman", "Bang", 5500.0, 20);
			//use service
			String resultMsg = empService.registerBatchEmployee(List.of(emp1,emp2,emp3,emp4,emp5));
			System.out.println(resultMsg);
		}
		catch (Exception e) {
			System.out.println("Internal problem :: "+e.getMessage());
		}*/
		
		/*try {
			//use service
			List<Employee> empList = empService.getEmployeeBySalaryRange(5000.0, 99500.0);
			empList.forEach(System.out::println);
		}
		catch (Exception e) {
			System.out.println("Internal problem :: "+e.getMessage());
		}*/
		
		try {
			//use service
			List<Object[]> empObjList = empService.getEmployeeDataByAddress("Delhi");
			empObjList.forEach(rows->{
				for(Object val : rows) {
					System.out.println(val+" ");
				}
				System.out.println();
			});
			
			System.out.println("------------------------------");
			//use repository
			List<Object> empObject = empService.getEmployeeNameByAddress("Delhi");
			for(Object val : empObject) {
				System.out.println(val+" ");
			}
			
			System.out.println("------------------------------");
			empService.getAllEmployeeDetailsByAddrs("Delhi").forEach(System.out::println);
			
			System.out.println("------------------------------");
			empService.getAllEmployeeDetailsByAddrsAndName("Delhi","Mahesh").forEach(System.out::println);
			
			System.out.println("------------------------------");
			empService.getAllEmployeeDetailsBasedOnSalary(5000.0, 10000.0).forEach(System.out::println);
			
			System.out.println("------------------------------");
			empService.getAllEmployeeDataByAddress("Delhi", "Hyd").forEach(System.out::println);
		}
		catch (Exception e) {
			System.out.println("Internal problem :: "+e.getMessage());
		}
	}

}
