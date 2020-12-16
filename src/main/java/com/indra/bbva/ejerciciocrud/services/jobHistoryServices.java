package com.indra.bbva.ejerciciocrud.services;

import java.util.Date;
import java.util.List;

import org.springframework.http.ResponseEntity;

import com.indra.bbva.ejerciciocrud.models.jobHistoryEntity;

public interface jobHistoryServices {
	public List<jobHistoryEntity> findAllJobHistories();	
	public jobHistoryEntity findJobHistoryById(String jobHistoryID);	
	public ResponseEntity<Object> createJobHistory(jobHistoryEntity jobHistory);	
	public String deleteJobHistory(String jobHistoryID);	
	public String updateJobHistory(jobHistoryEntity jobHistory);
}
