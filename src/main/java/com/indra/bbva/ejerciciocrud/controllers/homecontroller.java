package com.indra.bbva.ejerciciocrud.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class homecontroller {


	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String inicio() {
		
		return "Se ha bienvenida un usuario";
	}
	
	@RequestMapping(value="/create",method=RequestMethod.GET)
	public String crear() {
		
		return "Se ha creado un usuario";
	}
	
	@RequestMapping(value="/delete",method=RequestMethod.GET)
	public String eliminar() {
		
		return "Se ha eliminado un usuario";
	}
	
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public String listar() {
		
		return "Se listado los usuarios";
	}
	
	@RequestMapping(value="/buscar",method=RequestMethod.GET)
	public String buscar() {
		
		return "Se listado los usuarios";
	}
	
	@RequestMapping(value="/update",method=RequestMethod.GET)
	public String actualizar() {
		
		return "Se ha actualizar un usuario";
	}
}
