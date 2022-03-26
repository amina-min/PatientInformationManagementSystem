package com.mysoft.pims.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mysoft.pims.model.Information;

public interface InformationRepo extends JpaRepository<Information, Integer> {

	
	
}
