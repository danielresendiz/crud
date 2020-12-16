package com.indra.bbva.ejerciciocrud.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.indra.bbva.ejerciciocrud.models.regionsEntity;

public interface regionsServices {
	public List<regionsEntity> findAllRegions();	
	public regionsEntity findRegionById(Integer regionID);	
	public ResponseEntity<Object> createRegion(regionsEntity region);	
	public String deleteRegion(Integer regionID);	
	public String updateRegion(regionsEntity region);
}
