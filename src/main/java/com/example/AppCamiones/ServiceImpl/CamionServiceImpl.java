package com.example.AppCamiones.ServiceImpl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.AppCamiones.Model.CamionModel;
import com.example.AppCamiones.Repository.CamionRepository;
import com.example.AppCamiones.Service.CamionService;

@Service
public class CamionServiceImpl implements CamionService{

	@Autowired
	CamionRepository camionRepo;
	
	@Override
	public CamionModel addCamion(CamionModel camion) {
		CamionModel result = new CamionModel();
		
		try {
			result = camionRepo.save(camion);
		} catch (Exception e) {
			System.out.println("addCamion: "+e.getMessage());
		}
		return result;
	}

	@Override
	public ArrayList<CamionModel> getAllCamiones() {
		ArrayList<CamionModel> result = new ArrayList<>();
		
		try {
			result = (ArrayList<CamionModel>) camionRepo.findAll();
		} catch (Exception e) {
			System.out.println("getAllCamiones: "+e.getMessage());
		}
		
		return result;
	}

	@Override
	public CamionModel getCamionById(Integer id) {
		CamionModel result = new CamionModel();
		
		try {
			result = camionRepo.findById(id).get();
		} catch (Exception e) {
			System.out.println("getCamionById: "+e.getMessage());
		}
		
		return result;
	}

	@Override
	public ArrayList<CamionModel> getCamionesByFilter(CamionModel filter) {
		ArrayList<CamionModel> result = new ArrayList<>();
		
		try {
			ArrayList<CamionModel> camiones = (ArrayList<CamionModel>) camionRepo.findAll();
			for(CamionModel camion : camiones) {
				if((camion.getMatricula().equalsIgnoreCase(filter.getMatricula())) || (camion.getModelo().equalsIgnoreCase(filter.getModelo())) || (camion.getKm()==filter.getKm()) || (camion.getViaje().equals(filter.getViaje()))						) {
					result.add(camion);
				}
			}
		} catch (Exception e) {
			System.out.println("getCamionesByFilter: "+ e.getMessage());
		}
		
		return result;
	}
	
	@Override
	public CamionModel updateCamion(Integer id, CamionModel update) {
		CamionModel result = new CamionModel();
		
		try {
			CamionModel camion = camionRepo.findById(id).get();
			camion.setMatricula(update.getMatricula());
			camion.setModelo(update.getModelo());
			camion.setKm(update.getKm());
			camion.setViaje(update.getViaje());
			result=camion;
		} catch (Exception e) {
			System.out.println("updateCamion: "+ e.getMessage());
		}
		
		return result;
	}

	@Override
	public Boolean deleteCamion(Integer id) {
		Boolean result = false;
		
		try {
			camionRepo.deleteById(id);
			result=true;
		} catch (Exception e) {
			System.out.println("deleteCamion: "+ e.getMessage());
		}
		
		return result;
	}

}
