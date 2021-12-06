package com.unitest.junitest.repository;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.unitest.junitest.model.TEmployee;
import com.unitest.junitest.repository.TEmployeeRepository;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class JUnitDaoTest {
	@Autowired
	private TEmployeeRepository tEmployeeRepository;

	@Test
	@DisplayName("Test Dao layer save employee")
	void testSaveEmployee() {
		TEmployee tEmployee = new TEmployee();
		tEmployee.setEmpid("4");
		tEmployee.setEmpname("nama kary");
		tEmployeeRepository.save(tEmployee);
		
		TEmployee tEmployeeData = tEmployeeRepository.findByEmpid("4");
		assertEquals(tEmployee.getEmpid(), tEmployeeData.getEmpid());
	}

}
