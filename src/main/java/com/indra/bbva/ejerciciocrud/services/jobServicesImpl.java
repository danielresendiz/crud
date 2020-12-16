package com.indra.bbva.ejerciciocrud.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.indra.bbva.ejerciciocrud.models.jobEntity;
import com.indra.bbva.ejerciciocrud.repository.jobRepository;

@Service
public class jobServicesImpl implements jobServices
{
	@Autowired
	private jobRepository jobRepositorio;

	@Override
	public List<jobEntity> findAllJobs() {
		return (List<jobEntity>) jobRepositorio.findAll();
	}

	@Override
	public jobEntity findJobById(String jobID) {
		return jobRepositorio.findById(jobID).orElse(null);
	}

	@Override
	public ResponseEntity<Object> createJob(jobEntity job) {
		return new ResponseEntity<>(jobRepositorio.save(job), HttpStatus.OK);
	}

	@Override
	public String deleteJob(String jobID) {
		jobRepositorio.deleteById(jobID);
		return "Se ha elimiado el registro del job";
	}

	@Override
	public String updateJob(jobEntity job) {
		String jobID = job.getJobID();
		
		if (jobRepositorio.findById(jobID).isPresent()) {
			jobEntity jobToUpdate = new jobEntity();		
			jobToUpdate.setJobID(job.getJobID());		
			jobToUpdate.setJobTitle(job.getJobTitle());		
			jobToUpdate.setMinSalary(job.getMinSalary());
			jobToUpdate.setMaxSalary(job.getMaxSalary());
			jobRepositorio.save(jobToUpdate);				
			return "job modificado";			
		}			
		
		return "Error al modificar el job";
		
	}
}
