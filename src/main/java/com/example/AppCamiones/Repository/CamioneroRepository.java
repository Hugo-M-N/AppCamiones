package com.example.AppCamiones.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.AppCamiones.Model.CamioneroModel;

@Repository
public interface CamioneroRepository extends JpaRepository<CamioneroModel, Integer>{

}