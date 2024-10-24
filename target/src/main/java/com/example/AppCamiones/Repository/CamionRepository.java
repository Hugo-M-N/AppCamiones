package com.example.AppCamiones.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.AppCamiones.Model.CamionModel;

@Repository
public interface CamionRepository extends JpaRepository<CamionModel, Integer> {

}
