package com.indra.bbva.ejerciciocrud.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.indra.bbva.ejerciciocrud.models.departmentsEntity;


public interface departmentsServices {
	public List<departmentsEntity> findAllDepartments();	
	public departmentsEntity findDepartmentById(Integer departmentID);	
	public ResponseEntity<Object> createDepartment(departmentsEntity department);	
	public String deleteDepartment(Integer departmentID);	
	public String updateDepartment(departmentsEntity department);
}
