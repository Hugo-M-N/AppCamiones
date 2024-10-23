package com.example.AppCamiones.Service;

import java.util.ArrayList;

import com.example.AppCamiones.Model.CamionModel;

public interface CamionService {

	public CamionModel addCamion(CamionModel camion);
	
	public ArrayList<CamionModel> getAllCamiones();
	
	public CamionModel getCamionById(Integer id);
	
	public ArrayList<CamionModel> getCamionesByFilter(CamionModel filter);
	
	public CamionModel updateCamion(Integer id, CamionModel update);
	
	public Boolean deleteCamion(Integer id);
}
