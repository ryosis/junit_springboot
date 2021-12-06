package com.unitest.junitest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unitest.junitest.model.TEmployee;

@Repository
public interface TEmployeeRepository extends JpaRepository<TEmployee, Long>{
	TEmployee findByEmpid(String id);
}
