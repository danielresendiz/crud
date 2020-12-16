package com.indra.bbva.ejerciciocrud.controllers;

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

import com.indra.bbva.ejerciciocrud.models.departmentsEntity;
import com.indra.bbva.ejerciciocrud.services.departmentsServices;
@Controller
@RequestMapping("/departments")
public class departmentsController {
	@Autowired
	private departmentsServices depaService;
	
	
	
	@GetMapping("/list")
	public String findAllDepartments(Model model){
		List<departmentsEntity> lista= depaService.findAllDepartments();
		model.addAttribute("lista", lista);
		return "departments/findAllDepartments";
	}
	
	
	@GetMapping("/list/{departmentId}")
	public String findDepartmentById(@PathVariable Integer departmentId,Model model){
		departmentsEntity elemento= depaService.findDepartmentById(departmentId);
		model.addAttribute("elemento", elemento);
		return "departments/findDepartments";
	}
	
	/* desde posman en formato json
	 * {
    
			"departmentID": 10,
			"departmentName": "Administration",
			"managerID": 200,
			"locationID": { 
							"locationID":1200
						 }
		}
	 */
	@PostMapping(value="/create",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public String createDepartment(@RequestBody departmentsEntity department){
		depaService.createDepartment(department);
		return "crear";
	}
	
	@PutMapping(value="/update",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public String updateDepartment(@RequestBody departmentsEntity department) {
		depaService.updateDepartment( department);
		return "actualizar";
	}
	
	@DeleteMapping("/delete/{departmentID}")
	public String deleteDepartment(@PathVariable Integer departmentID) {
		depaService.deleteDepartment(departmentID);
		return "eliminar";
	}
}
