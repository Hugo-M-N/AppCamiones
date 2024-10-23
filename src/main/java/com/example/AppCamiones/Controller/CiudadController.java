package com.example.AppCamiones.Controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.AppCamiones.Model.CiudadModel;
import com.example.AppCamiones.Service.CiudadService;

@RestController
@RequestMapping("/ciudad")
public class CiudadController {

	@Autowired
	CiudadService ciudadService;
	
	@PostMapping("/add")
	public CiudadModel addCiudad(@RequestBody CiudadModel ciudad) {
		CiudadModel result = new CiudadModel();
		
		result = ciudadService.addCiudad(ciudad);
		
		return result;
	}
	
	@GetMapping("/getAll")
	public ArrayList<CiudadModel> getAllCiudades(){
		ArrayList<CiudadModel> result = new ArrayList<>();
		
		result = ciudadService.getAllCiudades();
		
		return result;
	}
	
	@GetMapping("/get/{id}")
	public CiudadModel getCiudadById(@PathVariable(name="id") Integer id) {
		CiudadModel result = new CiudadModel();
		
		result = ciudadService.getCiudadById(id);
		
		return result;
	}
	
	@GetMapping("/getByFilter")
	public ArrayList<CiudadModel> getCiudadesByFilter(@RequestBody CiudadModel filter){
		ArrayList<CiudadModel> result = new ArrayList<>();
		
		result = ciudadService.getCiudadesByFilter(filter);
		
		return result;
	}
	
	@PutMapping("/update/{id}")
	public CiudadModel updateCiudad(@PathVariable(name="id")Integer id, @RequestBody CiudadModel update) {
		CiudadModel result = new CiudadModel();
		
		result = ciudadService.updateCiudad(id, update);
		
		return result;
	}
	
	@DeleteMapping("/delete/{id}")
	public Boolean deleteCiudad(@PathVariable(name="id")Integer id) {
		Boolean result = false;
		
		result = ciudadService.deleteCiudad(id);
		
		return result;
	}
}
