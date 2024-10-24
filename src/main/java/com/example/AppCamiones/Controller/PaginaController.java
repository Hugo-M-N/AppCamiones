package com.example.AppCamiones.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
}
