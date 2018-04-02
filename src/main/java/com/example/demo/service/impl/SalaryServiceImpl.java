package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.CustomClass;
import com.example.demo.model.Salary;
import com.example.demo.repository.SalaryRepository;
import com.example.demo.service.SalaryService;
import com.mongodb.BasicDBObject;

@Service
public class SalaryServiceImpl implements SalaryService{

	private SalaryRepository salaryRepo;
	@Autowired
	public SalaryServiceImpl(SalaryRepository salaryRepo) {
		this.salaryRepo = salaryRepo;
	}
	
	@Override
	public void saveUserSalary(Salary object) throws Exception {
		salaryRepo.save(object);
		
	}

	@Override
	public void updateUserSalary(Salary object) throws Exception {
		salaryRepo.updateSalary(object);
		
	}

	@Override
	public List<CustomClass> getData(String id) throws Exception {
		
		return salaryRepo.getAllData(id);
	}

}
