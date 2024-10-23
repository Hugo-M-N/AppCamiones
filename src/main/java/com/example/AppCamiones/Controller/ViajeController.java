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

import com.example.AppCamiones.Model.ViajeModel;
import com.example.AppCamiones.Service.ViajeService;

@RestController
@RequestMapping("/viaje")
public class ViajeController {

	@Autowired
	ViajeService viajeService;
	
	@PostMapping("/add")
	public ViajeModel addViaje(@RequestBody ViajeModel viaje) {
		ViajeModel result = new ViajeModel();
		
		result = viajeService.addViaje(viaje);
		
		return result;
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
	public ViajeModel updateViaje(@PathVariable(name="id")Integer id, @RequestBody ViajeModel update) {
		ViajeModel result = new ViajeModel();
		
		result = viajeService.updateViaje(id, update);
		
		return result;
	}
	
	@DeleteMapping("/delete/{id}")
	public Boolean deleteViaje(@PathVariable(name="id")Integer id) {
		Boolean result = false;
		
		result = viajeService.deleteViaje(id);
		
		return result;
	}
}
