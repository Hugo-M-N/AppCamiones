package com.example.AppCamiones.Service;

import java.util.ArrayList;

import com.example.AppCamiones.Model.ViajeModel;

public interface ViajeService {

	public ViajeModel addViaje(ViajeModel viaje);
	
	public ArrayList<ViajeModel> getAllViajes();
	
	public ViajeModel getViajeById(Integer id);
	
	public ArrayList<ViajeModel> getViajesByFilter(ViajeModel filter);
	
	public ViajeModel updateViaje(Integer id, ViajeModel update);
	
	public Boolean deleteViaje(Integer id);
}
