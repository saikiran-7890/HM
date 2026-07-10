package com.kiran.www.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.kiran.www.entity.Medicine;
import com.kiran.www.entity.Patient;
import com.kiran.www.repository.MedicineRepository;

@Service
public class MedicineService {
	
	@Autowired
	private MedicineRepository medicineRepository;
	
	public Medicine addMedicine(Medicine medicine) {
		
		Medicine med = Medicine.build(null, medicine.getMedicineName(), medicine.getManfacturer(), 
				                      medicine.getQuantity(), medicine.getPrice(), medicine.getExpieryDate(), 
				                      medicine.getStockStatus());
		
		return medicineRepository.save(med);
	}
	
	
	public Medicine GetMedicine(Long medicineId) {
		
		return medicineRepository.findById(medicineId).get();
			
	}
	
	
	public Medicine StockUpdate(Medicine medicine) {
		
		Medicine med = medicineRepository.findById(medicine.getMedicineId()).get();
		med.setMedicineName(medicine.getMedicineName());
		med.setManfacturer(medicine.getManfacturer());
		med.setQuantity(medicine.getQuantity());
		med.setPrice(medicine.getPrice());
		med.setExpieryDate(medicine.getExpieryDate());
		med.setStockStatus(medicine.getStockStatus());
		
		return medicineRepository.save(medicine);	
		
	}
	
	public String DeleteMedicine(Long medicineId){
		
	  
	  if(!medicineRepository.existsById(medicineId)) {
			return "Record is not found";
			
		}else {
			Medicine med =  medicineRepository.findById(medicineId).get();
			medicineRepository.delete(med);
			
			return "Record Deleted Sucessfully";
		}
		
	}

}
