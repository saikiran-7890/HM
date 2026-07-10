package com.kiran.www.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

import com.kiran.www.entity.Doctor;
import com.kiran.www.service.DoctorService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/doctors")
public class DoctorController {
	
	@Autowired
	private DoctorService doctorService;
	
	@PostMapping("/adddoctor")
	public ResponseEntity<String> addDoctor(@RequestBody @Valid Doctor doctor) {
		
		return ResponseEntity.ok(doctorService.addDoctor(doctor));
		
	}
	
	@GetMapping("/show/{doctId}")
	public Doctor GetDoctor(@PathVariable Long DoctorId) {
		return doctorService.GetDoctor(DoctorId);
		
	}
	
	@GetMapping("/all/{doctId}")
	public List<Doctor>GetAllDoctors(@PathVariable Long DoctorId) {
		
		return doctorService.GetAllDoctors(DoctorId);
	}
	
	@PutMapping("/update/{doctId}")
	public Doctor UpdateDoctor(@RequestBody Doctor DoctorId) {	
		return doctorService.UpdateDoctor(DoctorId);
		
	}
	
	@PatchMapping("/column/{doctId}")
	public ResponseEntity<String> UpdateParticularColumn(@RequestBody @PathVariable Doctor DoctorId,Map<String,Object>DoctorData){
		
		return doctorService.UpdateParticularColumn(DoctorId,DoctorData);
	}
	
	@DeleteMapping("/delete/{doctId}")
	public String DeleteDoctor(Long DoctorId){
		return doctorService.DeleteDoctor(DoctorId);
		
	}

}
