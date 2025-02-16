package com.ankit.service;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.ankit.entity.Doctor;
import com.ankit.entity.Employee;
import com.mongodb.client.result.UpdateResult;

@Service
public class DoctorMgmtServiceImpl implements IDoctorAndEmployeeMgmtService {

	public DoctorMgmtServiceImpl() {
		System.out.println("IDoctorAndEmployeeMgmtService::0-param constructor");
	}
	
	//inject mongoRepository
	@Autowired
	private MongoTemplate mongoTemplate;

	@Override
	public String registerDoctor(Doctor doctor) throws Exception {
		System.out.println("IDoctorAndEmployeeMgmtService.registerDoctor()");
		//use template
		//Integer idValue = mongoTemplate.save(doctor).getId();
		Integer idValue = mongoTemplate.insert(doctor).getId();
		return idValue+" doctor is registered";
	}
	
	@Override
	public String registerBatchDoctor(List<Doctor> doctors) throws Exception {
		System.out.println("IDoctorAndEmployeeMgmtService.registerBatchDoctor()");
		//use template object
		Integer doctorSize = mongoTemplate.insertAll(doctors).size();
		return "no.of doctors register "+doctorSize;
	}
	
	@Override
	public List<Doctor> findDoctorByName(String name) throws Exception {
		System.out.println("IDoctorAndEmployeeMgmtService.findDoctorByName()");
		//create Query object
		Query query = new Query();
		query.addCriteria(Criteria.where("name").is(name));
		//use template object
		List<Doctor> doctors = mongoTemplate.find(query, Doctor.class);
		return doctors;
	}
	
	@Override
	public List<Doctor> findDoctorByAddrs(String addrs) throws Exception {
		System.out.println("IDoctorAndEmployeeMgmtService.findDoctorByAddrs()");
		//create Query object
		Query query = new Query();
		query.addCriteria(Criteria.where("addrs").is(addrs));
		//use template object
		return mongoTemplate.find(query, Doctor.class);
	}
	
	@Override
	public Doctor findDoctorById(Integer id) throws Exception {
		System.out.println("IDoctorAndEmployeeMgmtService.findDoctorById()");
		return mongoTemplate.findById(id, Doctor.class);
	}
	
	@Override
	public String findAndModifyDoctorByName(Integer id, String newName) throws Exception {
		System.out.println("IDoctorAndEmployeeMgmtService.findAndModifyDoctorByName()");
		//create Query Object
		Query query = new Query();
		query.addCriteria(Criteria.where("id").is(id));
		//create Update object
		Update update = new Update().set("name", newName);
		//use template
		Doctor doctor = mongoTemplate.findAndModify(query, update, Doctor.class);
		return doctor==null?"doctor not found":"doctor found and update";
	}
	
	@Override
	public String findAndModifyEmplyeeDeptByPriceRange(Integer dept, Double start, Double end)
			throws Exception {
		System.out.println("DoctorMgmtServiceImpl.findAndModifyEmplyeeDeptByPriceRange()");
		//create Query object
		Query query = new Query();
		query.addCriteria(Criteria.where("salary").gte(start).andOperator(Criteria.where("salary").lte(end)));
		//create Update object
		Update update = new Update().set("dept", dept);
		//use template object
		UpdateResult updateResult = mongoTemplate.updateMulti(query, update, Employee.class);
		return updateResult.getModifiedCount()+" no.of employee updated...";
	}
	
	@Override
	public String registerAndUpdateEmployeebyDesg(String desg, String name, String addrs, Double salary, Integer dept)
			throws Exception {
		System.out.println("DoctorMgmtServiceImpl.registerAndUpdateEmployeebyDesg()");
		//create Query object 
		Query query = new Query();
		query.addCriteria(Criteria.where("desg").is(desg));
		//create Update object
		Update update = new Update();
		update.set("name", name);
		update.set("addrs", addrs);
		update.setOnInsert("salary", salary);
		update.setOnInsert("id", new Random().nextInt(999));
		update.setOnInsert("dept", dept);
		//use template object
		UpdateResult result = mongoTemplate.upsert(query, update, Employee.class);
		return result.getModifiedCount()==0?"new Employee is register with id "+result.getUpsertedId():"Existing Employee is updated";
	}
	
	@Override
	public String findAndDeleteEmployeeById(Integer id) throws Exception {
		System.out.println("DoctorMgmtServiceImpl.findAndDeleteEmployeeById()");
		//create Query object
		Query query = new Query();
		query.addCriteria(Criteria.where("id").is(id));
		//use template object
		Employee emp = mongoTemplate.findAndRemove(query, Employee.class);
		return emp==null?id+" employee not found":id+" employee found and deleted";
	}
	
	@Override
	public String findAndDeleteAllEmployeeBySalaryRenage(Double startRange, Double endRange) throws Exception {
		System.out.println("DoctorMgmtServiceImpl.findAndDeleteAllEmployeeBySalaryRenage()");
		//create Query object
		Query query = new Query();
		query.addCriteria(Criteria.where("salary").gte(startRange).lte(endRange));
		//use template object
		int deleteCount = mongoTemplate.findAllAndRemove(query, Employee.class).size();
		return deleteCount+" no.of employee details deleted..";
	}
}

