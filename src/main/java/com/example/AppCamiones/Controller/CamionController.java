package com.example.AppCamiones.Controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.AppCamiones.Model.CamionModel;
import com.example.AppCamiones.Service.CamionService;
import org.springframework.web.bind.annotation.PutMapping;


@Controller
@RequestMapping("/camion")
public class CamionController {

	@Autowired
	CamionService camionService;
	
	@PostMapping("/add")
	public String addCamion(@ModelAttribute CamionModel camion) {
		CamionModel result = camionService.addCamion(camion);
		
		return "redirect:/camiones";
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
	public String updateCamion(@PathVariable Integer id, @ModelAttribute CamionModel update) {
		CamionModel result = camionService.updateCamion(id, update);
		
		return "redirect:/camiones";
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteCamion(@PathVariable(name="id")Integer id) {
		Boolean result = camionService.deleteCamion(id);
		
		return "redirect:/camiones";
	}
	
}






