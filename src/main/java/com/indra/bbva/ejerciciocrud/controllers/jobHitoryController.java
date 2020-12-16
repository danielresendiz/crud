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

import com.indra.bbva.ejerciciocrud.models.jobHistoryEntity;
import com.indra.bbva.ejerciciocrud.services.jobHistoryServices;

@Controller
@RequestMapping("/jobsHistory")
public class jobHitoryController {
	@Autowired
	private jobHistoryServices jobHistoryService;
	
	
	
	@GetMapping("/list")
	public String findAllJobHistories(Model model){
		List<jobHistoryEntity> lista= jobHistoryService.findAllJobHistories();
		model.addAttribute("lista", lista);
		return "jobHistory/findAllJobsHistory";
		
	}
	
	
	@GetMapping("/list/{jobHistoryId}")
	public String findJobHistoryById(@PathVariable String jobHistoryId,Model model){
		jobHistoryEntity elemento= jobHistoryService.findJobHistoryById(jobHistoryId);
		model.addAttribute("elemento", elemento);
		return "jobHistory/findJobHistory";
	}
	
	/*
	 * {
		    "employeeID": 102,
		    "startDate": "2001-01-13T06:00:00.000+00:00",
		    "endDate": "2006-07-24T05:00:00.000+00:00",
		    "jobID": "IT_PROG",
		    "departmentID": 60
		}
	 */
	@PostMapping(value="/create")//,consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public String createJobHistory(@RequestBody jobHistoryEntity jobHistory){
		jobHistoryService.createJobHistory(jobHistory);
		return "crear";
	}
	
	@PutMapping(value="/update")//,consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public String updateJobHistory(@RequestBody jobHistoryEntity jobHistory) {
		jobHistoryService.updateJobHistory( jobHistory);
		return "actualizar";
	}
	
	@DeleteMapping("/delete/{jobHistoryID}")
	public String deleteJobHistory(@PathVariable String jobHistoryID) {
		jobHistoryService.deleteJobHistory(jobHistoryID);
		return "eliminar";
	}
}
