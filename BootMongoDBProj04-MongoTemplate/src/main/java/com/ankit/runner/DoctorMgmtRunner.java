package com.ankit.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.ankit.service.IDoctorAndEmployeeMgmtService;

@Component
public class DoctorMgmtRunner implements CommandLineRunner {

	public DoctorMgmtRunner() {
		System.out.println("DoctorMgmtRunner::0-param constructor");
	}
	
	//inject service
	@Autowired
	private IDoctorAndEmployeeMgmtService service;

	@Override
	public void run(String... args) throws Exception {
		System.out.println("DoctorMgmtRunner.run()");
		try {
			//String resultMsg = service.registerDoctor(new Doctor(new Random().nextInt(9999), "Radha", "Hyd", "@gmail.com", "MBBS"));
			//create doctors object
			//Doctor d1 = new Doctor(new Random().nextInt(9999), "Ramesh", "Patna", "ramesh@gmail.com", "Ph.D");
			//Doctor d2 = new Doctor(new Random().nextInt(9999), "Rajesh", "Hyd", "rajesh@gmail.com", "Ph.D");
			//Doctor d3 = new Doctor(new Random().nextInt(9999), "Sujita", "Patna", "sujita@gmail.com", "D.H.S");
			//Doctor d4 = new Doctor(new Random().nextInt(9999), "Raushan", "Delhi", "raushanh@gmail.com", "Ph.D");
			//Doctor d5 = new Doctor(new Random().nextInt(9999), "Niraj", "Patna", "niraj@gmail.com", "MBBS");
			//use service
			//String resultMsg = service.registerBatchDoctor(List.of(d1,d2,d3,d4,d5));
			//System.out.println(resultMsg);
			//use service
			service.findDoctorByName("Raushan").forEach(System.out::println);
			System.out.println("------------------------------------------");
			service.findDoctorByAddrs("Patna").forEach(System.out::println);
			System.out.println("------------------------------------------");
			System.out.println(service.findDoctorById(3040));
			System.out.println("------------------------------------------");
			//String resultMsg = service.findAndModifyDoctorByName(3040, "Sangeeta");
			//String resultMsg = service.findAndModifyEmplyeeDeptByPriceRange(20, 6000.0, 10000.0);
			//String resultMsg = service.registerAndUpdateEmployeebyDesg("CEO", "Venu", "Bang", 122200.0, 30);
			//String resultMsg = service.findAndDeleteEmployeeById(8058);
			String resultMsg = service.findAndDeleteAllEmployeeBySalaryRenage(10000.0, 100000.0);
			System.out.println(resultMsg);
		}
		catch (Exception e) {
			System.out.println("Internal Problem :: "+e.getMessage());
		}
	}

}
