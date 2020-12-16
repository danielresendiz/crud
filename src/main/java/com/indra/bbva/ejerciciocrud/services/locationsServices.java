package com.indra.bbva.ejerciciocrud.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.indra.bbva.ejerciciocrud.models.locationsEntity;

public interface locationsServices {
	public List<locationsEntity> findAllLocations();	
	public locationsEntity findLocationById(Integer locationID);	
	public ResponseEntity<Object> createLocation(locationsEntity location);	
	public String deleteLocation(Integer locationID);	
	public String updateLocation(locationsEntity location);
}
