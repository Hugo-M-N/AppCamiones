package com.example.AppCamiones.Service;

import java.util.ArrayList;

import com.example.AppCamiones.Model.CiudadModel;

public interface CiudadService {

	public CiudadModel addCiudad(CiudadModel ciudad);
	
	public ArrayList<CiudadModel> getAllCiudades();
	
	public CiudadModel getCiudadById(Integer id);
	
	public ArrayList<CiudadModel> getCiudadesByFilter(CiudadModel filter);
	
	public Boolean deleteCiudad(Integer id);
}
