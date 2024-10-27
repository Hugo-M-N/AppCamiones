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

import com.example.AppCamiones.Model.ViajeModel;
import com.example.AppCamiones.Service.ViajeService;

@Controller
@RequestMapping("/viaje")
public class ViajeController {

	@Autowired
	ViajeService viajeService;
	
	@PostMapping("/add")
	public String addViaje(@ModelAttribute ViajeModel viaje) {
		ViajeModel result = viajeService.addViaje(viaje);
		
		return "redirect:/viajes";
	}
	
	@GetMapping("/getAll")
	public ArrayList<ViajeModel> getAllViajes(){
		ArrayList<ViajeModel> result = new ArrayList<>();
		
		result = viajeService.getAllViajes();
		
		return result;
	}
	
	@GetMapping("/get/{id}")
	public ViajeModel getViajeById(@PathVariable(name="id")Integer id) {
		ViajeModel result = new ViajeModel();
		
		result = viajeService.getViajeById(id);
		
		return result;
	}
	
	@GetMapping("/getByFilter")
	public ArrayList<ViajeModel> getViajesByFilter(@RequestBody ViajeModel filter){
		ArrayList<ViajeModel> result = new ArrayList<>();
		
		result = viajeService.getViajesByFilter(filter);
		
		return result;
	}
	
	@PutMapping("/update/{id}")
	public String updateViaje(@PathVariable(name="id")Integer id, @ModelAttribute ViajeModel update) {
		ViajeModel result = viajeService.updateViaje(id, update);
		
		return "redirect:/viajes";
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteViaje(@PathVariable(name="id")Integer id) {
		Boolean result = viajeService.deleteViaje(id);
		
		return "redirect:/viajes";
	}
}
