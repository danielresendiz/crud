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

import com.indra.bbva.ejerciciocrud.models.locationsEntity;
import com.indra.bbva.ejerciciocrud.services.locationsServices;

@Controller
@RequestMapping("/locations")
public class locationsController {
	@Autowired
	private locationsServices localService;
	
	
	
	@GetMapping("/list")
	public String findAllLocations(Model model){
		List<locationsEntity> lista=localService.findAllLocations();
		model.addAttribute("lista", lista);
		return "locations/findAllLocations";
		
	}
	
	
	@GetMapping("/list/{locationId}")
	public String findLocationById(@PathVariable Integer locationId,Model model){
		locationsEntity elemento =localService.findLocationById(locationId);
		model.addAttribute("elemento", elemento);
		return "locations/findLocation";
	}
	
	
	/* desde posman en formato json
 * {

	"locationID": 1000,
	"streetAddres": "1297 Via Cola di Rie",
	"postalCode": "00989",
	"city": "Roma",
	"stateProvince": null,
	"countryID": { 
					"countryID":"IT"
	
				 }
}
 */
	@PostMapping(value="/create",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public String createLocation(@RequestBody locationsEntity location){
		localService.createLocation(location);
		return "crear";
	}
	
	@PutMapping(value="/update",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public String updateLocation(@RequestBody locationsEntity location) {
		localService.updateLocation( location);
		return "actualizar";
	}
	
	@DeleteMapping("/delete/{locationID}")
	public String deleteLocation(@PathVariable Integer locationID) {
		localService.deleteLocation(locationID);
		return "eliminar";
	}
}
