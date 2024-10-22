package com.example.AppCamiones.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.AppCamiones.Model.PaqueteModel;

@Repository
public interface PaqueteRepository extends JpaRepository<PaqueteModel, Integer>{

}
