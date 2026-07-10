package com.kiran.www.controller;

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

import com.kiran.www.entity.Medicine;
import com.kiran.www.service.MedicineService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/Medicine")
public class MedicineController {
	
	@Autowired
	private MedicineService medicineService;
	
	
	@PostMapping("/add")
	public ResponseEntity<Medicine> addMedicine( @RequestBody @Valid Medicine medicine) {
		
		return new ResponseEntity<>(medicineService.addMedicine(medicine),HttpStatus.CREATED);
			
	}
	
	@GetMapping("/getMedicine/{medicineId}")
	public Medicine GetMedicine(@PathVariable Long medicineId) {
		
		return medicineService.GetMedicine(medicineId);
	}

	
	@PutMapping("update")
	public Medicine StockUpdate(@RequestBody Medicine medicine) {	
		
		return medicineService.StockUpdate(medicine);
	}
	
	@DeleteMapping("/delete/{MedicineId}")
	public String DeleteMedicine(@PathVariable Long medicineId){
		
		return medicineService.DeleteMedicine(medicineId);    
		
	}

}
