package com.example.AppCamiones.Controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.AppCamiones.Model.CamioneroModel;
import com.example.AppCamiones.Service.CamionService;
import com.example.AppCamiones.Service.CamioneroService;
import com.example.AppCamiones.Service.CiudadService;
import com.example.AppCamiones.Service.PaqueteService;
import com.example.AppCamiones.Service.ViajeService;

@Controller
public class PaginaController {
	
	@Autowired
	CamioneroService camioneroService;
	
	@Autowired
	CamionService camionService;
	
	@Autowired
	CiudadService ciudadService;
	
	@Autowired
	PaqueteService paqueteService;
	
	@Autowired
	ViajeService viajeService;

	@GetMapping("")
	public String index() {
		return "redirect:/inicio";
	}
	
	@GetMapping("/inicio")
	public String inicio(Model model) {
		Integer numCamioneros =  camioneroService.getAllCamioneros().size();
		Integer numCamiones = camionService.getAllCamiones().size();
		Integer numCiudades = ciudadService.getAllCiudades().size();
		Integer numPaquetes = paqueteService.getAllPaquetes().size();
		Integer numViajes = viajeService.getAllViajes().size();
		
		model.addAttribute("titulo", "Inicio");
		model.addAttribute("camioneros", numCamioneros);
		model.addAttribute("camiones", numCamiones);
		model.addAttribute("ciudades", numCiudades);
		model.addAttribute("paquetes", numPaquetes);
		model.addAttribute("viajes", numViajes);
		return "inicio";
	}
	
	@GetMapping("/camioneros")
	public String camioneros(Model model) {
		ArrayList<CamioneroModel> camioneros = camioneroService.getAllCamioneros();
		int maxId = camioneros.get(camioneros.size()-1).getIdCamionero()+1;
		
		model.addAttribute("camioneros",camioneros);
		model.addAttribute("maxId", maxId);
		
		return "camioneros";
	}
	
	@GetMapping("/camionero_formulario/{id}")
	public String camionero_formulario(@PathVariable(name="id")Integer id, Model model) {
		CamioneroModel camionero = camioneroService.getCamioneroById(id);
		camionero.setIdCamionero(id);
		
		model.addAttribute("camionero",camionero);
		model.addAttribute("url","/camionero/add");
		model.addAttribute("method", "post");
		
		return "camionero_formulario";
	}
	
	@GetMapping("/editar_camionero/{id}")
	public String editar_camionero(@PathVariable(name="id") Integer id, Model model) {
		CamioneroModel camionero = camioneroService.getCamioneroById(id);
		camionero.setIdCamionero(id);
		
		model.addAttribute("camionero",camionero);
		model.addAttribute("url","/camionero/update/"+id);
		model.addAttribute("method", "put");
		
		return "camionero_formulario";
	}
	 
	
}
