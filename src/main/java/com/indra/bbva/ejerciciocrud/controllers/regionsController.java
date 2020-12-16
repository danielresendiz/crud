package com.indra.bbva.ejerciciocrud.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.indra.bbva.ejerciciocrud.models.regionsEntity;
import com.indra.bbva.ejerciciocrud.services.regionsServices;

@Controller
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@RequestMapping("/regions")
public class regionsController {
	@Autowired
	private regionsServices regionService;
	
	
	//localhost:8080/regions/list
	@GetMapping("/list")
	public String findAllRegions(Model model){
		List<regionsEntity> lista =regionService.findAllRegions();
		model.addAttribute("lista", lista);
		return "regions/findAllRegions";
	}
	
	//localhost:8080/regions/list/id
	@GetMapping("/list/{regionId}")
	public String findRegionById(@PathVariable Integer regionId,Model model){
		regionsEntity elemento =regionService.findRegionById(regionId);
		model.addAttribute("elemento", elemento);
		return "regions/findRegion";
	}
	
	/* desde posman en formato json
	 * 	//localhost:8080/regions/create
	 * {
    
			"regionID": "2",
			"regionName": "America",
		}
	 */
	@PostMapping("/create")
	public String createRegion(@RequestBody regionsEntity region){
		regionService.createRegion(region);
		return "crear";
		
	}
	
	//desde posman
	@PutMapping("/update")
	public String updateRegion(@RequestBody regionsEntity region) {
		regionService.updateRegion( region);
		return "actualizar";
	}
	
	//localhost:8080/regions/delete/id
	@DeleteMapping("/delete/{regionID}")
	public String deleteRegion(@PathVariable Integer regionID) {
		regionService.deleteRegion(regionID);
		return "eliminar";
	}

}
