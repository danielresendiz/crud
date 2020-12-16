package com.indra.bbva.ejerciciocrud.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.indra.bbva.ejerciciocrud.models.departmentsEntity;
import com.indra.bbva.ejerciciocrud.repository.departmentsRepository;

@Service
public class departmentsServicesImpl implements departmentsServices {
	@Autowired
	private departmentsRepository deparRepositorio;
	

	@Override
	public List<departmentsEntity> findAllDepartments() {
		return (List<departmentsEntity>) deparRepositorio.findAll();
	}

	@Override
	public departmentsEntity findDepartmentById(Integer departmentID) {
		return deparRepositorio.findById(departmentID).orElse(null);
	}

	@Override
	public ResponseEntity<Object> createDepartment(departmentsEntity department) {
		return new ResponseEntity<>(deparRepositorio.save(department), HttpStatus.OK);

	}

	@Override
	public String deleteDepartment(Integer departmentID) {
		deparRepositorio.deleteById(departmentID);
		return "Se ha elimiado el registro de la department";
	}

	@Override
	public String updateDepartment(departmentsEntity department) {
		int departmentID =department.getDepartmentID();
	    
		if (deparRepositorio.findById(departmentID).isPresent()) {
			departmentsEntity depaToUpdate = new departmentsEntity();		
			depaToUpdate.setDepartmentID(department.getDepartmentID());		
			depaToUpdate.setDepartmentName(department.getDepartmentName());
			depaToUpdate.setManagerID(department.getManagerID());
			depaToUpdate.setLocationID(department.getLocationID());
			deparRepositorio.save(depaToUpdate);				
			return "Departament modificado";			
		}			
		
		return "Error al modificar el Departament";
	}
}
