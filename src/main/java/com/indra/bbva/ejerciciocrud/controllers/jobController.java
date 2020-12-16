package com.indra.bbva.ejerciciocrud.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.indra.bbva.ejerciciocrud.models.jobEntity;
import com.indra.bbva.ejerciciocrud.services.jobServices;

@Controller
@RequestMapping("/jobs")
public class jobController {
	@Autowired
	private jobServices jobService;
	
	
	
	@GetMapping("/list")
	public String findAllJobs(Model model){
		List<jobEntity> lista= jobService.findAllJobs();
		model.addAttribute("lista", lista);
		return "jobs/findAllJobs";
		
	}
	
	
	@GetMapping("/list/{jobId}")
	public String findJobById(@PathVariable String jobId,Model model){
		jobEntity elemento= jobService.findJobById(jobId);
		model.addAttribute("elemento", elemento);
		return "jobs/findJob";
		
	}
	
	@PostMapping("/create")
	public String createJob(@RequestBody jobEntity job){
		jobService.createJob(job);
		return "crear";
	}
	
	@PutMapping("/update")
	public String updateJob(@RequestBody jobEntity job) {
		jobService.updateJob( job);
		return "actualizar";
	}
	
	@DeleteMapping("/delete/{jobID}")
	public String deleteJob(@PathVariable String jobID) {
		jobService.deleteJob(jobID);
		return "eliminar";
	}

}
