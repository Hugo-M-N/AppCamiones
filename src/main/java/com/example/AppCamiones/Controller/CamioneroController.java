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
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.AppCamiones.Model.CamioneroModel;
import com.example.AppCamiones.Service.CamioneroService;

@Controller
@RequestMapping("/camionero")
public class CamioneroController {

	@Autowired
	CamioneroService camioneroService;
	
	@PostMapping("/add")
	public String addCamionero(@ModelAttribute CamioneroModel camionero) {
		CamioneroModel result  = camioneroService.addCamionero(camionero);
		
		return "redirect:/camioneros";
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
	public String updateCamionero(@PathVariable(name="id")Integer id, @ModelAttribute CamioneroModel update) {
		CamioneroModel result = camioneroService.updateCamionero(id, update);
		
		return "redirect:/camioneros";
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteCamionero(@PathVariable(name="id")Integer id) {
		Boolean result =  camioneroService.deleteCamionero(id);
		
		return "redirect:/camioneros";
	}
}
