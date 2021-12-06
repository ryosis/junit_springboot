package com.unitest.junitest.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.unitest.junitest.model.TEmployee;
import com.unitest.junitest.model.io.TEmployeeTemp;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class JUnitIntegrationTest {
	@Autowired
	JUTController jutController;
	
	@Test
	@DisplayName("Test integration layer")
	void testIntegration() throws Exception {
		TEmployeeTemp tEmployeeTemp = new TEmployeeTemp();
		tEmployeeTemp.setEmpid("5");
		tEmployeeTemp.setEmpname("tesint");
		
		jutController.setEmployee(tEmployeeTemp);
		
		ResponseEntity<Object> re = jutController.getEmployee("5");
		
		ObjectMapper om = new ObjectMapper();
		
		TEmployee tEmployee = om.convertValue(re.getBody(), TEmployee.class);
		System.out.println("tEmployeeTemp.getEmpid() "+tEmployeeTemp.getEmpid()+ " tEmployee.getEmpid() "+tEmployee.getEmpid());
		assertEquals(tEmployeeTemp.getEmpid(), tEmployee.getEmpid());
	}

}
