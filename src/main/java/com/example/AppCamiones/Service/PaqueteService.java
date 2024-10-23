package com.example.AppCamiones.Service;

import java.util.ArrayList;

import com.example.AppCamiones.Model.PaqueteModel;

public interface PaqueteService {

	public PaqueteModel addPaquete(PaqueteModel paquete);
	
	public ArrayList<PaqueteModel> getAllPaquetes();
	
	public PaqueteModel getPaqueteById(Integer id);
	
	public ArrayList<PaqueteModel> getPaquetesByFilter(PaqueteModel filter);
	
	public PaqueteModel updatePaquete(Integer id, PaqueteModel update);
	
	public Boolean deletePaquete(Integer id);
}
