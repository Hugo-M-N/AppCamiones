package com.example.AppCamiones.Controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.AppCamiones.Model.CamionModel;
import com.example.AppCamiones.Model.CamioneroModel;
import com.example.AppCamiones.Model.CiudadModel;
import com.example.AppCamiones.Model.PaqueteModel;
import com.example.AppCamiones.Model.ViajeModel;
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
	
	@GetMapping("/login")
	public String login() {
		return "login";
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
		int maxId=1;
		if(camioneros.size()>0) {
			maxId = camioneros.get(camioneros.size()-1).getIdCamionero()+1;
		}
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
	
	@GetMapping("/camiones")
	public String camiones(Model model) {
		ArrayList<CamionModel> camiones = camionService.getAllCamiones();
		int maxId = 1;
		if(camiones.size()>0) {
			maxId = camiones.get(camiones.size()-1).getIdCamion()+1;
		}
		
		model.addAttribute("camiones",camiones);
		model.addAttribute("maxId", maxId);
		
		return "camiones";
	}
	 
	
	@GetMapping("/camion_formulario/{id}")
	public String camion_formulario(@PathVariable(name="id")Integer id, Model model) {
		CamionModel camion = camionService.getCamionById(id);
		camion.setIdCamion(id);
		
		model.addAttribute("camion",camion);
		model.addAttribute("url","/camion/add");
		model.addAttribute("method", "post");
		
		return "camion_formulario";
	}
	
	@GetMapping("/editar_camion/{id}")
	public String editar_camion(@PathVariable(name="id") Integer id, Model model) {
		CamionModel camion = camionService.getCamionById(id);
		camion.setIdCamion(id);
		
		model.addAttribute("camion",camion);
		model.addAttribute("url","/camion/update/"+id);
		model.addAttribute("method", "put");
		
		return "camion_formulario";
	}
	
	@GetMapping("/ciudades")
	public String ciudades(Model model) {
		ArrayList<CiudadModel> ciudades = ciudadService.getAllCiudades();
		int maxId = 1;
		if(ciudades.size()>0) {
			maxId = ciudades.get(ciudades.size()-1).getIdCiudad()+1;
		}
		
		model.addAttribute("ciudades",ciudades);
		model.addAttribute("maxId", maxId);
		
		return "ciudades";
	}
	 
	
	@GetMapping("/ciudad_formulario/{id}")
	public String ciudad_formulario(@PathVariable(name="id")Integer id, Model model) {
		CiudadModel ciudad = ciudadService.getCiudadById(id);
		ciudad.setIdCiudad(id);
		
		model.addAttribute("ciudad",ciudad);
		model.addAttribute("url","/ciudad/add");
		model.addAttribute("method", "post");
		
		return "ciudad_formulario";
	}
	
	@GetMapping("/editar_ciudad/{id}")
	public String editar_ciudad(@PathVariable(name="id") Integer id, Model model) {
		CiudadModel ciudad = ciudadService.getCiudadById(id);
		ciudad.setIdCiudad(id);
		
		model.addAttribute("ciudad",ciudad);
		model.addAttribute("url","/ciudad/update/"+id);
		model.addAttribute("method", "put");
		
		return "ciudad_formulario";
	}
	
	@GetMapping("/paquetes")
	public String paquetes(Model model) {
		ArrayList<PaqueteModel> paquetes = paqueteService.getAllPaquetes();
		int maxId = 1;
		if(paquetes.size()>0) {
			maxId = paquetes.get(paquetes.size()-1).getIdPaquete()+1;
		}
		
		model.addAttribute("paquetes",paquetes);
		model.addAttribute("maxId", maxId);
		
		return "paquetes";
	}
	 
	
	@GetMapping("/paquete_formulario/{id}")
	public String paquete_formulario(@PathVariable(name="id")Integer id, Model model) {
		PaqueteModel paquete = paqueteService.getPaqueteById(id);
		paquete.setIdPaquete(id);
		ArrayList<CiudadModel> ciudades= ciudadService.getAllCiudades();
		ArrayList<CamioneroModel> camioneros = camioneroService.getAllCamioneros();

		
		model.addAttribute("paquete",paquete);
		model.addAttribute("url","/paquete/add");
		model.addAttribute("method", "post");
		model.addAttribute("ciudades", ciudades);
		model.addAttribute("camioneros", camioneros);

		
		return "paquete_formulario";
	}
	
	@GetMapping("/editar_paquete/{id}")
	public String editar_paquete(@PathVariable(name="id") Integer id, Model model) {
		PaqueteModel paquete = paqueteService.getPaqueteById(id);
		paquete.setIdPaquete(id);
		ArrayList<CiudadModel> ciudades= ciudadService.getAllCiudades();
		ArrayList<CamioneroModel> camioneros = camioneroService.getAllCamioneros();

		
		model.addAttribute("paquete",paquete);
		model.addAttribute("url","/paquete/update/"+id);
		model.addAttribute("method", "put");
		model.addAttribute("ciudades", ciudades);
		model.addAttribute("camioneros", camioneros);

		
		return "paquete_formulario";
	}
	
	@GetMapping("/viajes")
	public String viajes(Model model) {
		ArrayList<ViajeModel> viajes = viajeService.getAllViajes();
		int maxId = 1;
		if(viajes.size()>0) {
			maxId = viajes.get(viajes.size()-1).getIdViaje()+1;
		}
		
		model.addAttribute("viajes",viajes);
		model.addAttribute("maxId", maxId);
		
		return "viajes";
	}
	 
	
	@GetMapping("/viaje_formulario/{id}")
	public String viaje_formulario(@PathVariable(name="id")Integer id, Model model) {
		ViajeModel viaje = viajeService.getViajeById(id);
		viaje.setIdViaje(id);
		ArrayList<CamioneroModel> camioneros = camioneroService.getAllCamioneros();
		ArrayList<CamionModel> camiones = camionService.getAllCamiones();
		
		model.addAttribute("viaje",viaje);
		model.addAttribute("url","/viaje/add");
		model.addAttribute("method", "post");
		model.addAttribute("camioneros", camioneros);
		model.addAttribute("camiones", camiones);
		
		return "viaje_formulario";
	}
	
	@GetMapping("/editar_viaje/{id}")
	public String editar_viaje(@PathVariable(name="id") Integer id, Model model) {
		ViajeModel viaje = viajeService.getViajeById(id);
		viaje.setIdViaje(id);
		ArrayList<CamioneroModel> camioneros = camioneroService.getAllCamioneros();
		ArrayList<CamionModel> camiones = camionService.getAllCamiones();
		
		model.addAttribute("viaje",viaje);
		model.addAttribute("url","/viaje/update/"+id);
		model.addAttribute("method", "put");
		model.addAttribute("camioneros", camioneros);
		model.addAttribute("camiones", camiones);

		
		return "viaje_formulario";
	}
}
