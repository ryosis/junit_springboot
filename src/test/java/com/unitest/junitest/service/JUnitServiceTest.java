package com.unitest.junitest.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.unitest.junitest.model.TEmployee;
import com.unitest.junitest.repository.TEmployeeRepository;

@ExtendWith(MockitoExtension.class)
class JUnitServiceTest {
	@InjectMocks
	TEmployeeService tEmployeeService;
	
	@Mock
	TEmployeeRepository tEmployeeRepository;	
	
	@Test
	@DisplayName("Test Layer service")
	void testService() {
		TEmployee tEmployee = new TEmployee();
		tEmployee.setEmpid("10");
		tEmployee.setEmpname("sis0");
		
		when(tEmployeeRepository.findByEmpid("10")).thenReturn(tEmployee);
		
		TEmployee tEmployeeData = tEmployeeService.getEmployeeById("10");
//		System.out.println("tEmployee.getEmpid() "+tEmployee.getEmpid()+" tEmployeeData.getEmpid() "+tEmployeeData.getEmpid());
		assertEquals(tEmployee.getEmpid(), tEmployeeData.getEmpid());
	}

}
