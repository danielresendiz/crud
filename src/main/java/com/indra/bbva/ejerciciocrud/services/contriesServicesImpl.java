package com.indra.bbva.ejerciciocrud.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.indra.bbva.ejerciciocrud.models.countriesEntity;
import com.indra.bbva.ejerciciocrud.models.locationsEntity;
import com.indra.bbva.ejerciciocrud.models.regionsEntity;
import com.indra.bbva.ejerciciocrud.repository.countriesRepository;
import com.indra.bbva.ejerciciocrud.repository.regionsRepository;

@Service
public class contriesServicesImpl implements contriesServices{

	@Autowired
	private countriesRepository countryRepositorio;
	
	@Override
	public List<countriesEntity> findAllCountries() {
		return (List<countriesEntity>) countryRepositorio.findAll();
		
	}

	@Override
	public countriesEntity findCountriesById(String countryID) {
		return countryRepositorio.findById(countryID).orElse(null);
		
	}

	@Override
	public ResponseEntity<Object> createCountries( countriesEntity country) {
								
		return new ResponseEntity<>(countryRepositorio.save(country), HttpStatus.OK);
		

	}

	@Override
	public String deleteCountries(String countryID) {
		countryRepositorio.deleteById(countryID);
		return "Se ha elimiado el registro del country";
	}

	@Override
	public String updateCountries( countriesEntity country) {
		
		
		String countryID =country.getCountryID();
	    
		if (countryRepositorio.findById(countryID).isPresent()) {
			countriesEntity countryToUpdate = new countriesEntity();		
			countryToUpdate.setCountryID(country.getCountryID());		
			countryToUpdate.setCountryName(country.getCountryName());
			countryToUpdate.setRegionID(country.getRegionID());
			countryRepositorio.save(countryToUpdate);				
			return "country modificado";			
		}
		
		return "Error al modificar el Country";
	}


	
	
}
