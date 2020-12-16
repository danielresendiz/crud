package com.indra.bbva.ejerciciocrud.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.indra.bbva.ejerciciocrud.models.regionsEntity;
import com.indra.bbva.ejerciciocrud.repository.regionsRepository;

@Service
public class regionsServicesImpl implements regionsServices{
	@Autowired
	private regionsRepository regionRepositorio;

	@Override
	public List<regionsEntity> findAllRegions() {
		return (List<regionsEntity>) regionRepositorio.findAll();
	}

	@Override
	public regionsEntity findRegionById(Integer regionID) {
		return regionRepositorio.findById(regionID).orElse(null);
	}

	@Override
	public ResponseEntity<Object> createRegion(regionsEntity region) {
		
			return new ResponseEntity<>(regionRepositorio.save(region), HttpStatus.OK);

	}

	@Override
	public String deleteRegion(Integer regionID) {
		regionRepositorio.deleteById(regionID);
		return "Se ha elimiado el registro de la region";
	}

	@Override
	public String updateRegion(regionsEntity region) {
		int regionID =region.getRegionID();
	    //String regionID= String.valueOf(num);
		if (regionRepositorio.findById(regionID).isPresent()) {
			regionsEntity regionToUpdate = new regionsEntity();		
			regionToUpdate.setRegionID(region.getRegionID());		
			regionToUpdate.setRegionName(region.getRegionName());		
			regionRepositorio.save(regionToUpdate);				
			return "Region modificada";			
		}			
		
		return "Error al modificar la Region";
	}
}
