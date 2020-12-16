package com.indra.bbva.ejerciciocrud.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.indra.bbva.ejerciciocrud.models.employeesEntity;
import com.indra.bbva.ejerciciocrud.services.employeesServices;

@Controller
@RequestMapping("/employees")
public class employeesController {
	@Autowired
	private employeesServices employService;
	
	
	
	@GetMapping("/list")
	public String findAllEmployees(Model model){
		List<employeesEntity> lista= employService.findAllEmployees();
		model.addAttribute("lista", lista);
		System.out.println(new Date());
		return "employees/findAllEmployees";
	}
	
	
	@GetMapping("/list/{employeeId}")
	public String findEmployeeById(@PathVariable Integer employeeId,Model model){
		employeesEntity elemento =employService.findEmployeeById(employeeId);
		model.addAttribute("elemento", elemento);
		return "employees/findEmploy";
	}
	
	@PostMapping(value="/create")//,consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public String createEmployee(@RequestBody employeesEntity employee){
		employService.createEmployee(employee);
		
		return "crear";
	}
	
	@PutMapping(value="/update")//,consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public String updateEmployee(@RequestBody employeesEntity employee) {
		employService.updateEmployee( employee);
		return "actualizar";
	}
	
	@DeleteMapping("/delete/{employeeID}")
	public String deleteEmployee(@PathVariable Integer employeeID) {
		employService.deleteEmployee(employeeID);
		return "eliminar";
	}
}
