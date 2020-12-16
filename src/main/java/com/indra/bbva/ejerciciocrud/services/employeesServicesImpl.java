package com.indra.bbva.ejerciciocrud.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.indra.bbva.ejerciciocrud.models.employeesEntity;
import com.indra.bbva.ejerciciocrud.repository.employeesRepository;

@Service
public class employeesServicesImpl implements employeesServices{
	@Autowired
	private employeesRepository employRepositorio;
	
	@Override
	public List<employeesEntity> findAllEmployees() {
		return (List<employeesEntity>) employRepositorio.findAll();
	}

	@Override
	public employeesEntity findEmployeeById(Integer employeeID) {


		return employRepositorio.findById(employeeID).orElse(null);
	}

	@Override
	public ResponseEntity<Object> createEmployee(employeesEntity employee) {

		return new ResponseEntity<>(employRepositorio.save(employee), HttpStatus.OK);
	}

	@Override
	public String deleteEmployee(Integer employeeID) {
		employRepositorio.deleteById(employeeID);
		return "Se ha elimiado el registro de la department";
	}

	@Override
	public String updateEmployee(employeesEntity employee) {
		int employeeID =employee.getEmployeID();
	    
		if (employRepositorio.findById(employeeID).isPresent()) {
			employeesEntity employToUpdate = new employeesEntity();		
			employToUpdate.setEmployeID(employee.getEmployeID());		
			employToUpdate.setFirstName(employee.getFirstName());
			employToUpdate.setLastName(employee.getLastName());
			employToUpdate.setEmail(employee.getEmail());
			employToUpdate.setPhoneNumbre(employee.getPhoneNumbre());		
			employToUpdate.setHireDate(employee.getHireDate());
			employToUpdate.setJobID(employee.getJobID());
			employToUpdate.setSalary(employee.getSalary());
			employToUpdate.setCommissionPCT(employee.getCommissionPCT());
			employToUpdate.setManagerID(employee.getManagerID());
			employToUpdate.setDepartmentID(employee.getDepartmentID());
			employRepositorio.save(employToUpdate);				
			return "Departament modificado";			
		}			
		
		return "Error al modificar el Departament";
	}
	
}
