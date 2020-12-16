package com.indra.bbva.ejerciciocrud.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.indra.bbva.ejerciciocrud.models.employeesEntity;

public interface employeesServices {
	public List<employeesEntity> findAllEmployees();	
	public employeesEntity findEmployeeById(Integer employeeID);	
	public ResponseEntity<Object> createEmployee(employeesEntity employee);	
	public String deleteEmployee(Integer employeeID);	
	public String updateEmployee(employeesEntity employee);
}
