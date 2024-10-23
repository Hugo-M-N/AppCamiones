package com.example.AppCamiones.ServiceImpl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.AppCamiones.Model.ViajeModel;
import com.example.AppCamiones.Repository.ViajeRepository;
import com.example.AppCamiones.Service.ViajeService;

@Service
public class ViajeServiceImpl implements ViajeService{

	@Autowired
	ViajeRepository viajeRepo;
	
	@Override
	public ViajeModel addViaje(ViajeModel viaje) {
		ViajeModel result = new ViajeModel();
		
		try {
			result = viajeRepo.save(viaje);
		} catch (Exception e) {
			System.out.println("addViaje: "+ e.getMessage());
		}
		
		return result;
	}

	@Override
	public ArrayList<ViajeModel> getAllViajes() {
		ArrayList<ViajeModel> result = new ArrayList<>();
		
		try {
			result = (ArrayList<ViajeModel>) viajeRepo.findAll();
		} catch (Exception e) {
			System.out.println("getAllViajes: "+ e.getMessage());
		}
		
		return result;
	}

	@Override
	public ViajeModel getViajeById(Integer id) {
		ViajeModel result = new ViajeModel();
		
		try {
			result = viajeRepo.findById(id).get();
		} catch (Exception e) {
			System.out.println("getViajeById: "+ e.getMessage());
		}
		
		return result;
	}

	@Override
	public ArrayList<ViajeModel> getViajesByFilter(ViajeModel filter) {
		ArrayList<ViajeModel> result = new ArrayList<>();
		
		try {
			ArrayList<ViajeModel> viajes = (ArrayList<ViajeModel>) viajeRepo.findAll();
			for(ViajeModel viaje : viajes) {
				if( (viaje.getCamion().equals(filter.getCamion())) || (viaje.getCamionero().equals(filter.getCamionero())) || (viaje.getFechaViaje().equals(filter.getFechaViaje())) ) {
					result.add(viaje);
				}
			}
		} catch (Exception e) {
			System.out.println("getViajeByFilter: "+ e.getMessage());
		}
		
		return result;
	}
	
	@Override
	public ViajeModel updateViaje(Integer id, ViajeModel update) {
		ViajeModel result = new ViajeModel();
		
		try {
			ViajeModel viaje = viajeRepo.findById(id).get();
			viaje.setCamionero(update.getCamionero());
			viaje.setCamion(update.getCamion());
			viaje.setFechaViaje(update.getFechaViaje());
			result = viaje;
		} catch (Exception e) {
			System.out.println("updateViaje: "+ e.getMessage());
		}
		
		return result;
	}

	@Override
	public Boolean deleteViaje(Integer id) {
		Boolean result = false;
		
		try {
			viajeRepo.deleteById(id);
			result=true;
		} catch (Exception e) {
			System.out.println("deleteViaje: "+ e.getMessage());
		}
		
		return result;
	}

}
