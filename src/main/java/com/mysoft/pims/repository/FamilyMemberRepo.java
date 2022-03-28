package com.mysoft.pims.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mysoft.pims.model.FamilyMember;

public interface FamilyMemberRepo extends JpaRepository<FamilyMember, Integer> {

	List<FamilyMember> findByPatientId(int patientId);
	
}
