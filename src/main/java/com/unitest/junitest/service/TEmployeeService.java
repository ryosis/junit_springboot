package com.unitest.junitest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.unitest.junitest.model.TEmployee;
import com.unitest.junitest.repository.TEmployeeRepository;

@Component
public class TEmployeeService {

	@Autowired
    private TEmployeeRepository tEmployeeRepository;
	
	public TEmployee getEmployeeById(String id) {
		return tEmployeeRepository.findByEmpid(id);
	}
	
	public String setEmployee(String empId, String empName) {
		TEmployee tEmployee = new TEmployee();
		tEmployee.setEmpid(empId);
		tEmployee.setEmpname(empName);
		tEmployeeRepository.save(tEmployee);
		return "true";
	}
}
