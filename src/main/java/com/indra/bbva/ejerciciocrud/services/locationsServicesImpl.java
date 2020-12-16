package com.indra.bbva.ejerciciocrud.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.indra.bbva.ejerciciocrud.models.locationsEntity;
import com.indra.bbva.ejerciciocrud.repository.locationsRepository;

@Service
public class locationsServicesImpl implements locationsServices{
	@Autowired
	private locationsRepository localRepositorio;

	@Override
	public List<locationsEntity> findAllLocations() {
		return (List<locationsEntity>) localRepositorio.findAll();
	}

	@Override
	public locationsEntity findLocationById(Integer locationID) {
		return localRepositorio.findById(locationID).orElse(null);	
	
	}

	@Override
	public ResponseEntity<Object> createLocation(locationsEntity location) {
		return new ResponseEntity<>(localRepositorio.save(location), HttpStatus.OK);
	}

	@Override
	public String deleteLocation(Integer locationID) {
		localRepositorio.deleteById(locationID);
		return "Se ha elimiado el registro de la location";
	
	}

	@Override
	public String updateLocation(locationsEntity location) {
		int locationID =location.getLocationID();
	    
		if (localRepositorio.findById(locationID).isPresent()) {
			locationsEntity localToUpdate = new locationsEntity();		
			localToUpdate.setLocationID(location.getLocationID());		
			localToUpdate.setStreetAddres(location.getStreetAddres());
			localToUpdate.setPostalCode(location.getPostalCode());
			localToUpdate.setCity(location.getCity());
			localToUpdate.setStateProvince(location.getStateProvince());
			localToUpdate.setCountryID(location.getCountryID());
			localRepositorio.save(localToUpdate);				
			return "location modificado";			
		}			
		
		return "Error al modificar el location";
	}
}
