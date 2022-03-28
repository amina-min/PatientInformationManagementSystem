package com.mysoft.pims.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mysoft.pims.model.FamilyMember;
import com.mysoft.pims.repository.FamilyMemberRepo;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class FamilyMemberController {

	@Autowired
	private FamilyMemberRepo repo;

	@PostMapping("/familyMemberAdd")
	public ResponseEntity<?> save(@RequestBody FamilyMember entity) {
		Map<String, Object> map = new HashMap<>();
		try {
			FamilyMember info = repo.save(entity);
			map.put("message", "Successfully saved");
			map.put("data", info);
			map.put("statusCode", 200);
			return ResponseEntity.ok(map);
		} catch (Exception e) {
			e.printStackTrace();
			map.put("message", "Patient saved failed");
			map.put("data", null);
			map.put("statusCode", 400);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(map);
		}
	}

	@GetMapping("/getAllfamilyMember")
	public ResponseEntity<?> getInformation() {
		Map<String, Object> map = new HashMap<>();
		try {
			List<FamilyMember> info = (List<FamilyMember>) repo.findAll();
			map.put("message", "Information get successfully");
			map.put("data", info);
			map.put("statusCode", 200);
			return ResponseEntity.ok(map);
		} catch (Exception e) {
			e.printStackTrace();
			map.put("message", "Information fetch failed");
			map.put("data", null);
			map.put("statusCode", 400);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(map);
		}
	}
	
	
	
	@GetMapping("/getFamilyMembers/{patientId}")
	public ResponseEntity<?> getFamilyMembersByPatientId(@PathVariable  Integer patientId) {
		Map<String, Object> map = new HashMap<>();
		try {
			List<FamilyMember> familyMembers = repo.findByPatientId(patientId);
			map.put("message", "Information get successfully");
			map.put("data", familyMembers);
			map.put("statusCode", 200);
			return ResponseEntity.ok(map);
		} catch (Exception e) {
			e.printStackTrace();
			map.put("message", "Information fetch failed");
			map.put("data", null);
			map.put("statusCode", 400);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(map);
		}
	}
	
	
	


	@PostMapping("/informationUpdate")
	public ResponseEntity<?> update(@RequestBody FamilyMember entity) {
		Map<String, Object> map = new HashMap<>();
		try {
			FamilyMember info = repo.save(entity);
			map.put("message", "Information updated successfully");
			map.put("data", info);
			map.put("statusCode", 200);
			return ResponseEntity.ok(map);
		} catch (Exception e) {
			e.printStackTrace();
			map.put("message", "Information updated failed");
			map.put("data", null);
			map.put("statusCode", 400);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(map);
		}
	}

	@GetMapping(value = "/deleteInformation/{id}")
	public ResponseEntity<?> delete(@PathVariable(value = "id") Integer id) {
		Map<String, Object> map = new HashMap<>();
		FamilyMember info = repo.findById(id).get();
		try {
			repo.delete(info);
			map.put("message", "Information deleted successfully");
			map.put("data", info);
			map.put("statusCode", 200);
			return ResponseEntity.ok(map);
		} catch (Exception e) {
			e.printStackTrace();
			map.put("message", "Information deletation failed");
			map.put("data", null);
			map.put("statusCode", 400);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(map);
		}
	}

}
