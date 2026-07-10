package com.kiran.www.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kiran.www.dto.StaffRequest;
import com.kiran.www.entity.Staff;
import com.kiran.www.service.StaffService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/Staff")
public class StaffController {
	
	@Autowired
	private StaffService staffService;
	

	@PostMapping("/add")
	public ResponseEntity<String> addStaff(@RequestBody @Valid Staff staff) {
		
		return ResponseEntity.ok(staffService.addStaff(staff));
		
	}
	
	@PutMapping("/update")
	public Staff UpdateStaff(@RequestBody @PathVariable Staff staffID) {
		
		return staffService.UpdateStaff(staffID);
	}
	
	@GetMapping("/all")
	public List<Staff>GetStaff(Staff staff) {
		
		return staffService.GetStaff(staff);
			
	}
	@DeleteMapping("/delete/{staffId}")
	public String deleteStaff(@PathVariable Long staffId) {
	    return staffService.deleteStaff(staffId);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
