package com.example.AppCamiones.Service;

import java.util.ArrayList;

import com.example.AppCamiones.Model.CamioneroModel;

public interface CamioneroService {

	public CamioneroModel addCamionero(CamioneroModel camionero);
	
	public ArrayList<CamioneroModel> getAllCamioneros();
	
	public CamioneroModel getCamioneroById(Integer id);
	
	public ArrayList<CamioneroModel> getCamionerosByFilter(CamioneroModel filter);
	
	public Boolean deleteCamionero(Integer id);
}
