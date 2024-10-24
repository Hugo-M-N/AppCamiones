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

import com.example.AppCamiones.Model.CamioneroModel;
import com.example.AppCamiones.Service.CamioneroService;

@RestController
@RequestMapping("/camionero")
public class CamioneroController {

	@Autowired
	CamioneroService camioneroService;
	
	@PostMapping("/add")
	public CamioneroModel addCamionero(@RequestBody CamioneroModel camionero) {
		CamioneroModel result  = new CamioneroModel();
		
		result = camioneroService.addCamionero(camionero);
		
		return result;
	}
	
	@GetMapping("/getAll")
	public ArrayList<CamioneroModel> getAllCamioneros(){
		ArrayList<CamioneroModel> result = new ArrayList<>();
		
		result = camioneroService.getAllCamioneros();
		
		return result;
	}
	
	@GetMapping("/get/{id}")
	public CamioneroModel getCamioneroById(Integer id) {
		CamioneroModel result = new CamioneroModel();
		
		result = camioneroService.getCamioneroById(id);
		
		return result;
	}
	
	@GetMapping("/getByFilter")
	public ArrayList<CamioneroModel> getCamionerosByFilter(CamioneroModel filter){
		ArrayList<CamioneroModel> result = new ArrayList<>();
		
		result = camioneroService.getCamionerosByFilter(filter);
		
		return result;
	}
	
	@PutMapping("/update/{id}")
	public CamioneroModel updateCamionero(@PathVariable(name="id")Integer id, @RequestBody CamioneroModel update) {
		CamioneroModel result = new CamioneroModel();
		
		result = camioneroService.updateCamionero(id, update);
		
		return result;
	}
	
	@DeleteMapping("/delete/{id}")
	public Boolean deleteCamionero(@PathVariable(name="id")Integer id) {
		Boolean result = false;
		
		result = camioneroService.deleteCamionero(id);
		
		return result;
	}
}
