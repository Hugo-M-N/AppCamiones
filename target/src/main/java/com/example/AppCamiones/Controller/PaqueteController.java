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

import com.example.AppCamiones.Model.PaqueteModel;
import com.example.AppCamiones.Service.PaqueteService;

@RestController
@RequestMapping("/paquete")
public class PaqueteController {

	@Autowired
	PaqueteService paqueteService;
	
	@PostMapping("/add")
	public PaqueteModel addPaquete(@RequestBody PaqueteModel paquete) {
		PaqueteModel result = new PaqueteModel();
		
		result = paqueteService.addPaquete(paquete);
		
		return result;
	}
	
	@GetMapping("/getAll")
	public ArrayList<PaqueteModel> getAllPaquetes(){
		ArrayList<PaqueteModel> result = new ArrayList<>();
		
		result = paqueteService.getAllPaquetes();
		
		return result;
	}
	
	@GetMapping("/get/{id}")
	public PaqueteModel getPaqueteById(@PathVariable(name="id")Integer id) {
		PaqueteModel result = new PaqueteModel();
		
		result = paqueteService.getPaqueteById(id);
		
		return result;
	}
	
	@GetMapping("/getByFilter")
	public ArrayList<PaqueteModel> getPaquetesByFilter(@RequestBody PaqueteModel filter){
		ArrayList<PaqueteModel> result = new ArrayList<>();
		
		result = paqueteService.getPaquetesByFilter(filter);
		
		return result;
	}
	
	@PutMapping("/update/{id}")
	public PaqueteModel updatePaquete(@PathVariable(name="id")Integer id, @RequestBody PaqueteModel update) {
		PaqueteModel result = new PaqueteModel();
		
		result = paqueteService.updatePaquete(id, update);
		
		return result;
	}
	
	@DeleteMapping("/delete/{id}")
	public Boolean deletePaquete(@PathVariable(name="id")Integer id) {
		Boolean result = false;
		
		result = paqueteService.deletePaquete(id);
		
		return result;
	}
}
