package com.indra.bbva.ejerciciocrud.services;


import org.springframework.http.ResponseEntity;

import com.indra.bbva.ejerciciocrud.models.countriesEntity;
import com.indra.bbva.ejerciciocrud.models.regionsEntity;

import java.util.List;

public interface contriesServices {
	
	public List<countriesEntity> findAllCountries();	
	public countriesEntity findCountriesById(String countryID);	
	public ResponseEntity<Object> createCountries(countriesEntity country);	
	public String deleteCountries(String countryID);	
	public String updateCountries(countriesEntity country);

}
