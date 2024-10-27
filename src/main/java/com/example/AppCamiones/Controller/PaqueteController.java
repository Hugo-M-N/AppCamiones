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

import com.example.AppCamiones.Model.PaqueteModel;
import com.example.AppCamiones.Service.PaqueteService;

@Controller
@RequestMapping("/paquete")
public class PaqueteController {

	@Autowired
	PaqueteService paqueteService;
	
	@PostMapping("/add")
	public String addPaquete(@ModelAttribute PaqueteModel paquete) {
		PaqueteModel result = paqueteService.addPaquete(paquete);
		
		return "redirect:/paquetes";
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
	public String updatePaquete(@PathVariable(name="id")Integer id, @ModelAttribute PaqueteModel update) {
		PaqueteModel result = paqueteService.updatePaquete(id, update);
		
		return "redirect:/paquetes";
	}
	
	@DeleteMapping("/delete/{id}")
	public String deletePaquete(@PathVariable(name="id")Integer id) {
		Boolean result = paqueteService.deletePaquete(id);
		
		return "redirect:/paquetes";
	}
}
