package com.indra.bbva.ejerciciocrud.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.indra.bbva.ejerciciocrud.models.jobHistoryEntity;
import com.indra.bbva.ejerciciocrud.repository.jobHistoryRepository;

@Service
public class jobHistoryServicesImpl implements jobHistoryServices{
	@Autowired
	private jobHistoryRepository jobHitoryRepositorio; 
	
	@Override
	public List<jobHistoryEntity> findAllJobHistories() {
		return (List<jobHistoryEntity>) jobHitoryRepositorio.findAll();
	}

	@Override
	public jobHistoryEntity findJobHistoryById(String jobHistoryID) {
		Date jobdate=ParseFecha(jobHistoryID); 
		return jobHitoryRepositorio.findById(jobdate).orElse(null);
	}

	@Override
	public ResponseEntity<Object> createJobHistory(jobHistoryEntity jobHistory) {

		return new ResponseEntity<>(jobHitoryRepositorio.save(jobHistory), HttpStatus.OK);
		
	}

	@Override
	public String deleteJobHistory(String jobHistoryID) {
		Date jobdate=ParseFecha(jobHistoryID); 
		jobHitoryRepositorio.deleteById(jobdate);
		return "Se ha elimiado el registro de la jobHistory";
	}

	@Override
	public String updateJobHistory(jobHistoryEntity jobHistory) {
		Date jobHistoryID =jobHistory.getStartDate();
	    
		if (jobHitoryRepositorio.findById(jobHistoryID).isPresent()) {
			jobHistoryEntity jobHistoryToUpdate = new jobHistoryEntity();		
			jobHistoryToUpdate.setEmployeeID(jobHistory.getEmployeeID());		
			jobHistoryToUpdate.setStartDate(jobHistory.getStartDate());
			jobHistoryToUpdate.setEndDate(jobHistory.getEndDate());
			jobHistoryToUpdate.setJobID(jobHistory.getJobID());
			jobHistoryToUpdate.setDepartmentID(jobHistory.getDepartmentID());
			jobHitoryRepositorio.save(jobHistoryToUpdate);				
			return "Departament modificado";			
		}			
		
		return "Error al modificar el Departament";
	}

	 public static Date ParseFecha(String fecha)
	    {
	        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
	        Date fechaDate = null;
	        try {
	            fechaDate = formato.parse(fecha);
	        } 
	        catch (ParseException ex) 
	        {
	            System.out.println(ex);
	        }
	        return fechaDate;
	    }
}
