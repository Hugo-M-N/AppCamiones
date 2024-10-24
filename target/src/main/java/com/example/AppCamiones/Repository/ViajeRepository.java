package com.example.AppCamiones.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.AppCamiones.Model.ViajeModel;

@Repository
public interface ViajeRepository extends JpaRepository<ViajeModel, Integer>{

}
