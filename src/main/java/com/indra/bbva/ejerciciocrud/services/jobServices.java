package com.indra.bbva.ejerciciocrud.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.indra.bbva.ejerciciocrud.models.jobEntity;

public interface jobServices {
	public List<jobEntity> findAllJobs();	
	public jobEntity findJobById(String jobID);	
	public ResponseEntity<Object> createJob(jobEntity job);	
	public String deleteJob(String jobID);	
	public String updateJob(jobEntity job);
}
