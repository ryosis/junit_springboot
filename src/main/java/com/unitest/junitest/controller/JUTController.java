package com.unitest.junitest.controller;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.unitest.junitest.model.io.TEmployeeTemp;
import com.unitest.junitest.service.TEmployeeService;

@RestController
@RequestMapping("/api")
public class JUTController {
	
	private static final Logger logger = LoggerFactory.getLogger(JUTController.class);
	
	@Autowired
	TEmployeeService tEmployeeService;
	
	@GetMapping(path="/get-employee")
	public ResponseEntity<Object> getEmployee(@RequestParam(name="empid") String empId) {
		System.out.println("empId :::::::: "+empId);
		return new ResponseEntity<Object>(tEmployeeService.getEmployeeById(empId), HttpStatus.OK); 
	}				
	
	@PostMapping(path="/set-employee")
	public ResponseEntity<Object> setEmployee(@RequestBody TEmployeeTemp tEmployeeTemp) {
		String returnSetEmployee = "false";
		String message = "false";
		try {
			returnSetEmployee = tEmployeeService.setEmployee(tEmployeeTemp.getEmpid(), tEmployeeTemp.getEmpname());
			message = returnSetEmployee;
		} catch (Exception e) {
			message = e.getMessage();
			logger.error(message);
		}		
		HashMap<String, String> response = new HashMap<String, String>();
		response.put("status", returnSetEmployee);
		response.put("message", message);
		return new ResponseEntity<Object>(response,HttpStatus.OK);	
	}
}
