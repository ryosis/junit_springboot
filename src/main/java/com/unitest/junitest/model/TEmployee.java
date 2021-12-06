package com.unitest.junitest.model;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Data;


/**
 * The persistent class for the t_employee database table.
 * 
 */
@Entity
@Table(name="t_employee")
@Data
@NamedQuery(name="TEmployee.findAll", query="SELECT t FROM TEmployee t")
public class TEmployee implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String empid;

	private String empname;	

}