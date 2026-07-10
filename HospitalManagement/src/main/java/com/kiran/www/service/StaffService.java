package com.kiran.www.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.kiran.www.dto.StaffRequest;
import com.kiran.www.entity.Staff;
import com.kiran.www.exceptions.DuplicateRecordException;
//import com.kiran.www.exceptions.ResourceNotFoundException;
import com.kiran.www.repository.StaffRepository;

@Service 
public class StaffService {
	
	@Autowired
	private StaffRepository staffRepository;
	
	public String addStaff(Staff staff) {

	    if (staffRepository.existsByEmail(staff.getEmail())) {
	        throw new DuplicateRecordException("Staff email already exists");
	    }

	    staffRepository.save(staff);

	    return "Staff successfully added";
	}
	
	public Staff UpdateStaff(Staff staffId) {
		
		Staff stf = staffRepository.findById(staffId.getStaffId()).get();
		
		stf.setStaffName(staffId.getStaffName());
		stf.setStaffRole(staffId.getStaffRole());
		stf.setMobile(staffId.getMobile());
		stf.setEmail(staffId.getEmail());
		stf.setSalary(staffId.getSalary());
		stf.setJoinDate(staffId.getJoinDate());
		
		return staffRepository.save(staffId);
		
	}
	
	public List<Staff> GetStaff(Staff staff){
		
		return staffRepository.findAll();
	}
	
	public String deleteStaff(Long staffId){
		
		if(!staffRepository.existsById(staffId)) {
			return "Record is not found";
			
		}else {
			Staff staff=staffRepository.findById(staffId).get();
			staffRepository.delete(staff);
			
			return "Record Deleted Sucessfully";
		}
		
		
	}
	
	

}
