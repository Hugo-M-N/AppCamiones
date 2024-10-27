package com.example.AppCamiones.Controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.AppCamiones.Model.CiudadModel;
import com.example.AppCamiones.Service.CiudadService;

@Controller
@RequestMapping("/ciudad")
public class CiudadController {

	@Autowired
	CiudadService ciudadService;
	
	@PostMapping("/add")
	public String addCiudad(@ModelAttribute CiudadModel ciudad) {
		CiudadModel result = ciudadService.addCiudad(ciudad);
		
		return "redirect:/ciudades";
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
	public String updateCiudad(@PathVariable(name="id")Integer id, @ModelAttribute CiudadModel update) {
		CiudadModel result = ciudadService.updateCiudad(id, update);
		
		return "redirect:/ciudades";
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteCiudad(@PathVariable(name="id")Integer id) {
		Boolean result = ciudadService.deleteCiudad(id);
		
		return "redirect:/ciudades";
	}
}
