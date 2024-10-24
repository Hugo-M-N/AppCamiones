package com.example.AppCamiones.ServiceImpl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.AppCamiones.Model.PaqueteModel;
import com.example.AppCamiones.Repository.PaqueteRepository;
import com.example.AppCamiones.Service.PaqueteService;

@Service
public class PaqueteServiceImlp implements PaqueteService{

	@Autowired
	PaqueteRepository paqueteRepo;
	
	@Override
	public PaqueteModel addPaquete(PaqueteModel paquete) {
		PaqueteModel result = new PaqueteModel();
		
		try {
			result = paqueteRepo.save(paquete);
		} catch (Exception e) {
			System.out.println("addPaquete: "+ e.getMessage());
		}
		
		return result;
	}

	@Override
	public ArrayList<PaqueteModel> getAllPaquetes() {
		ArrayList<PaqueteModel> result = new ArrayList<>();
		
		try {
			result = (ArrayList<PaqueteModel>) paqueteRepo.findAll();
		} catch (Exception e) {
			System.out.println("getAllPaquetes");
		}
		
		return result;
	}

	@Override
	public PaqueteModel getPaqueteById(Integer id) {
		PaqueteModel result = new PaqueteModel();
		
		try {
			result = paqueteRepo.findById(id).get();
		} catch (Exception e) {
			System.out.println("getPaqueteById: "+ e.getMessage());
		}
		
		return result;
	}

	@Override
	public ArrayList<PaqueteModel> getPaquetesByFilter(PaqueteModel filter) {
		ArrayList<PaqueteModel> result = new ArrayList<>();
		
		try {
			ArrayList<PaqueteModel> paquetes = (ArrayList<PaqueteModel>) paqueteRepo.findAll();
			for(PaqueteModel paquete : paquetes) {
				if((paquete.getCodigoPaquete().equalsIgnoreCase(filter.getCodigoPaquete())) || (paquete.getDescripcion().equalsIgnoreCase(filter.getDescripcion())) || (paquete.getDestino().equalsIgnoreCase(filter.getDestino())) ||
					(paquete.getCiudadDestino().equals(filter.getCiudadDestino())) || (paquete.getCamionero().equals(filter.getCamionero()))
						) {
					result.add(paquete);
				}
			}
		} catch (Exception e) {
			System.out.println("getPaquetesByFilter: "+ e.getMessage());
		}
		
		return result;
	}
	
	@Override
	public PaqueteModel updatePaquete(Integer id, PaqueteModel update) {
		PaqueteModel result = new PaqueteModel();
		
		try {
			PaqueteModel paquete = paqueteRepo.findById(id).get();
			paquete.setCodigoPaquete(update.getCodigoPaquete());
			paquete.setDescripcion(update.getDescripcion());
			paquete.setCiudadDestino(update.getCiudadDestino());
			paquete.setDestino(update.getDestino());
			paquete.setCamionero(update.getCamionero());
			result=paquete;
		} catch (Exception e) {
			System.out.println("updatePaquete: "+ e.getMessage());
		}
	
		return result;
	}

	@Override
	public Boolean deletePaquete(Integer id) {
		Boolean result = false;
		
		try {
			paqueteRepo.deleteById(id);
			result=true;
		} catch (Exception e) {
			System.out.println("deletePaquete: "+ e.getMessage());
		}
		
		return result;
	}

}
