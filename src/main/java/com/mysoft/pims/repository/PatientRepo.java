package com.mysoft.pims.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mysoft.pims.model.Patient;

public interface PatientRepo extends JpaRepository<Patient, Integer> {

}
