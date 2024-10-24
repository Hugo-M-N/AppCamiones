package com.example.AppCamiones.Controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.AppCamiones.Model.CamionModel;
import com.example.AppCamiones.Service.CamionService;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/camion")
public class CamionController {

	@Autowired
	CamionService camionService;
	
	@PostMapping("/add")
	public CamionModel addCamion(@RequestBody CamionModel camion) {
		CamionModel result = new CamionModel();
		
		result = camionService.addCamion(camion);
		
		return result;
	}
	
	@GetMapping("/getAll")
	public ArrayList<CamionModel> getAllCamiones() {
		ArrayList<CamionModel> result = new ArrayList<>();
		
		result = camionService.getAllCamiones();
		
		return result;
	}
	
	@GetMapping("/get/{id}")
	public CamionModel getCamionById(@PathVariable(name="id") Integer id) {
		CamionModel result = new CamionModel();
		
		result = camionService.getCamionById(id);
		
		return result;
	}
	
	@GetMapping("/getByFilter")
	public ArrayList<CamionModel> getCamionesByFilter(@RequestBody CamionModel filter){
		ArrayList<CamionModel> result = new ArrayList<>();
		
		result = camionService.getCamionesByFilter(filter);
		
		return result;
	}
	
	@PutMapping("/update/{id}")
	public CamionModel updateCamion(@PathVariable Integer id, @RequestBody CamionModel update) {
		CamionModel result = new CamionModel();
		
		result = camionService.updateCamion(id, update);
		
		return result;
	}
	
	@DeleteMapping("/delete/{id}")
	public Boolean deleteCamion(@PathVariable(name="id")Integer id) {
		Boolean result = false;
		
		result = camionService.deleteCamion(id);
		
		return result;
	}
	
}






