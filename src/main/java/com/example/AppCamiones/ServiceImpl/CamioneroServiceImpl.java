package com.example.AppCamiones.ServiceImpl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.AppCamiones.Model.CamioneroModel;
import com.example.AppCamiones.Repository.CamioneroRepository;
import com.example.AppCamiones.Service.CamioneroService;

@Service
public class CamioneroServiceImpl implements CamioneroService{
	
	@Autowired
	CamioneroRepository camioneroRepo;

	@Override
	public CamioneroModel addCamionero(CamioneroModel camionero) {
		CamioneroModel result = new CamioneroModel();
		
		try {
			result = camioneroRepo.save(camionero);
		} catch (Exception e) {
			System.out.println("addCamionero: "+ e.getMessage());
		}
		
		return result;
	}

	@Override
	public ArrayList<CamioneroModel> getAllCamioneros() {
		ArrayList<CamioneroModel> result = new ArrayList<>();
		
		try {
			result = (ArrayList<CamioneroModel>) camioneroRepo.findAll();
		} catch (Exception e) {
			System.out.println("getAllCamioneros: "+ e.getMessage());
		}
		
		return result;
	}

	@Override
	public CamioneroModel getCamioneroById(Integer id) {
		CamioneroModel result = new CamioneroModel();
		
		try {
			result = camioneroRepo.findById(id).get();
		} catch (Exception e) {
			System.out.println("getCamioneroById: "+ e.getMessage());
		}
		
		return result;
	}

	@Override
	public ArrayList<CamioneroModel> getCamionerosByFilter(CamioneroModel filter) {
		ArrayList<CamioneroModel> result = new ArrayList<>();
		
		try {
			ArrayList<CamioneroModel> camioneros = (ArrayList<CamioneroModel>) camioneroRepo.findAll();
			for(CamioneroModel camionero : camioneros) {
				if((camionero.getNombre().equalsIgnoreCase(filter.getNombre())) || (camionero.getDni().equalsIgnoreCase(filter.getDni())) || (camionero.getDireccion().equalsIgnoreCase(filter.getDireccion())) ||
					(camionero.getPaquetes().equals(filter.getPaquetes())) || (camionero.getSalario()==filter.getSalario()) || (camionero.getTelefono().equalsIgnoreCase(filter.getTelefono())) || (camionero.getViajes().equals(filter.getViajes()))
						) {
					result.add(camionero);
				}
			}
		} catch (Exception e) {
			System.out.println("getCamionerosByFilter: "+ e.getMessage());
		}		
		
		
		return result;
	}
	
	@Override
	public CamioneroModel updateCamionero(Integer id, CamioneroModel update) {
		CamioneroModel result = new CamioneroModel();
		
		try {
			CamioneroModel camionero = camioneroRepo.findById(id).get();
			camionero.setNombre(update.getNombre());
			camionero.setDni(update.getDni());
			camionero.setDireccion(update.getDireccion());
			camionero.setSalario(update.getSalario());
			camionero.setTelefono(update.getTelefono());
			camionero.setPaquetes(update.getPaquetes());
			camionero.setViajes(update.getViajes());
			result = camionero;
			camioneroRepo.save(result);
		} catch (Exception e) {
			System.out.println("updateCamionero: "+ e.getMessage());
		}
		
		return result;
	}

	@Override
	public Boolean deleteCamionero(Integer id) {
		Boolean result = false;
		
		try {
			camioneroRepo.deleteById(id);
			result=true;
		} catch (Exception e) {
			System.out.println("deleteCamionero: "+e.getMessage());
		}
		
		return result;
	}

}
