package com.unitest.junitest;

import static org.junit.jupiter.api.Assertions.*;

import java.net.URI;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.unitest.junitest.model.TEmployee;

class JUnitSystemTest {

	@Test
	@DisplayName("Get Data Employee from real system")
	void testGetDataEmployee() throws Exception {
		RestTemplate restTemplate = new RestTemplate();
		
		String baseUrl = "http://localhost:8080/junitest/api/get-employee?empid=3";
		
		URI uri = new URI(baseUrl);
		
		ResponseEntity<Object> result = restTemplate.getForEntity(uri, Object.class);
		
		ObjectMapper om = new ObjectMapper();
		
		TEmployee tEmployee = om.convertValue(result.getBody(), TEmployee.class);
		
		assertEquals("3", tEmployee.getEmpid());
	}

}
