package com.example.AppCamiones.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.AppCamiones.Model.CiudadModel;

@Repository
public interface CiudadRepository extends JpaRepository<CiudadModel, Integer>{

}
