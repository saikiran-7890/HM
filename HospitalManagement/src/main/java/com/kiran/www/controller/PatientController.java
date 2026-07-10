package com.kiran.www.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kiran.www.entity.Patient;
import com.kiran.www.service.PatientService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/patient")
public class PatientController {
	
	@Autowired
	private PatientService patientService;
	
	
	@PostMapping("/add")
	public ResponseEntity<String> addPatient(@RequestBody @Valid Patient patientrequest) {
		
		return  ResponseEntity.ok(patientService.addPatient(patientrequest));
		
	}
	
	@GetMapping("/show/{patientId}")
	public Patient GetPatient(@PathVariable Long patientId) {
	
		return patientService.GetPatient(patientId);
		
	}
	
	@GetMapping("/all")
	public List<Patient> GetAllPatients(@PathVariable Long patientId) {
		
		return patientService.GetAllPatients(patientId);
	}
	
	@PutMapping("/update")
	public Patient UpdatePatient(@RequestBody Patient patientId) {
		
		return patientService.UpdatePatient(patientId);
		
	}
	
	@PatchMapping("/column/{patientId}")
	public ResponseEntity<String> UpdateParticularName(@PathVariable @RequestBody Patient patient, Map<String,Object>Data) {
		
		return patientService.UpdateParticularName(patient,Data);
	}
	
	@DeleteMapping("/delete/{patientId}")
	public String DeletePatient(@PathVariable Long patientId) {
		
		return patientService.DeletePatient(patientId);
	}
	
	
	

}
