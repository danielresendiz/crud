package com.indra.bbva.ejerciciocrud.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.indra.bbva.ejerciciocrud.models.countriesEntity;
import com.indra.bbva.ejerciciocrud.models.regionsEntity;
import com.indra.bbva.ejerciciocrud.services.contriesServices;


@Controller
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@RequestMapping("/countries")
public class countriesController {
	@Autowired
	private contriesServices countriesService;
	
	
	//acceder desde el navegador
	@GetMapping("/list")
	public String findAllCountries(Model model ){
	  List<countriesEntity> lista= countriesService.findAllCountries();
	  model.addAttribute("lista", lista);
	  return "countries/findAllCountries";
	}
	
	
	@GetMapping("/list/{countryId}")
	public String findCountriesById(@PathVariable String countryId,Model model){
		countriesEntity elemento =countriesService.findCountriesById(countryId);		
		model.addAttribute("elemento", elemento);
		return "countries/findCountry";
	}
	
	/* desde posman en formato json
	 * {
    
			"countryID": "AA",
			"countryName": "Argelia",
			"regionID": { "regionID":4  }
		}
	 */
	@PostMapping(value="/create",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public String createCountries(@RequestBody countriesEntity country){
		countriesService.createCountries(country);
		return "crear";
	}
	
	@PutMapping(value="/update",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public String updateCountries(@RequestBody countriesEntity country) {
		countriesService.updateCountries( country);
		return "actualizar";
	}
	
	
	@DeleteMapping("/delete/{countryID}")
	public String deleteCountries(@PathVariable String countryID) {
		countriesService.deleteCountries(countryID);
		return "eliminar";
	}
	
}

