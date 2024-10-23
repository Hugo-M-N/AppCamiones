package com.example.AppCamiones.ServiceImpl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.AppCamiones.Model.CiudadModel;
import com.example.AppCamiones.Repository.CiudadRepository;
import com.example.AppCamiones.Service.CiudadService;

@Service
public class CiudadServiceImpl implements CiudadService{

	@Autowired
	CiudadRepository ciudadRepo;
	
	@Override
	public CiudadModel addCiudad(CiudadModel ciudad) {
		CiudadModel result = new CiudadModel();
		
		try {
			result = ciudadRepo.save(ciudad);
		} catch (Exception e) {
			System.out.println("addCiudad: "+ e.getMessage());
		}
		
		return result;
	}

	@Override
	public ArrayList<CiudadModel> getAllCiudades() {
		ArrayList<CiudadModel> result = new ArrayList<>();
		
		try {
			result = (ArrayList<CiudadModel>) ciudadRepo.findAll();
		} catch (Exception e) {
			System.out.println("getAllCiudades: "+e.getMessage());
		}
		
		return result;
	}

	@Override
	public CiudadModel getCiudadById(Integer id) {
		CiudadModel result = new CiudadModel();
		
		try {
			result = ciudadRepo.findById(id).get();
		} catch (Exception e) {
			System.out.println("getCiudadById: "+ e.getMessage());
		}
		
		return result;
	}

	@Override
	public ArrayList<CiudadModel> getCiudadesByFilter(CiudadModel filter) {
		ArrayList<CiudadModel> result = new ArrayList<>();
		
		try {
			ArrayList<CiudadModel> ciudades = (ArrayList<CiudadModel>) ciudadRepo.findAll();
			for(CiudadModel ciudad : ciudades) {
				if((ciudad.getCodigoCiudad().equalsIgnoreCase(filter.getCodigoCiudad())) || (ciudad.getNombreCiudad().equalsIgnoreCase(filter.getNombreCiudad())) || (ciudad.getPaquetes().equals(filter.getPaquetes())) ) {
					result.add(ciudad);
				}
			}
		} catch (Exception e) {
			System.out.println("getCiudadesByFilter: "+ e.getMessage());
		}		
		
		return result;
	}
	
	@Override
	public CiudadModel updateCiudad(Integer id, CiudadModel update) {
		CiudadModel result = new CiudadModel();
		
		try {
			CiudadModel ciudad = ciudadRepo.findById(id).get();
			ciudad.setCodigoCiudad(update.getCodigoCiudad());
			ciudad.setNombreCiudad(update.getNombreCiudad());
			ciudad.setPaquetes(update.getPaquetes());
			result=ciudad;
		} catch (Exception e) {
			System.out.println("updateCiudad: "+ e.getMessage());
		}
		
		return result;
		
	}

	@Override
	public Boolean deleteCiudad(Integer id) {
		Boolean result = false;
		
		try {
			ciudadRepo.deleteById(id);
			result=true;
		} catch (Exception e) {
			System.out.println("deleteCiudad: "+ e.getMessage());
		}
		
		return result;
	}

}
