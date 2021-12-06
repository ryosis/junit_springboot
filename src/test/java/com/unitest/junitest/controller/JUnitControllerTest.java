package com.unitest.junitest.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.unitest.junitest.model.TEmployee;
import com.unitest.junitest.service.TEmployeeService;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = JUTController.class )
class JUnitControllerTest {

	@Autowired
    MockMvc mockMvc;
	
	@MockBean
	TEmployeeService tEmployeeService;	

	@Test
	@DisplayName("Test controller layer get method")
	void testController() throws Exception {
		TEmployee tEmployee = new TEmployee();
		tEmployee.setEmpid("10");
		tEmployee.setEmpname("sis");
		Mockito.when(tEmployeeService.getEmployeeById("10")).thenReturn(tEmployee);
		
		mockMvc.perform(MockMvcRequestBuilders.
		        get("/api/get-employee?empid=10").accept(MediaType.APPLICATION_JSON)).
		        andExpect(MockMvcResultMatchers.status().isOk())
		        .andExpect(MockMvcResultMatchers.content().json("{'empid':'10','empname':'sis'}"));			
	}

}
