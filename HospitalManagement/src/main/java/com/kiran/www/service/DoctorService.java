package com.kiran.www.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.kiran.www.entity.Doctor;
//import com.kiran.www.entity.Medicine;
import com.kiran.www.exceptions.DuplicateRecordException;
import com.kiran.www.repository.DoctorRepository;

@Service
public class DoctorService {
	
	@Autowired
	private DoctorRepository doctorRepository;
	
	public String addDoctor(Doctor doctor) {
		
		if(doctorRepository.existsByEmail(doctor.getEmail())) {
			
			throw new DuplicateRecordException("Email already Exists");
			
		}		
		doctorRepository.save(doctor);
		return"Doctor added Sucessfully";
		
	}
	
	public Doctor GetDoctor(Long DoctorId) {	
		return doctorRepository.findById(DoctorId).get();
	}


	public List<Doctor> GetAllDoctors(Long DoctorId){
		return doctorRepository.findAll();
		
	}
	
	public Doctor UpdateDoctor(Doctor DoctorId) {
		
		Doctor Dtr = doctorRepository.findById(DoctorId.getDoctorId()).get();
		
		Dtr.setDoctorName(DoctorId.getDoctorName());
		Dtr.setSpecialization(DoctorId.getSpecialization());
		Dtr.setQualification(DoctorId.getQualification());
		Dtr.setExperience(DoctorId.getExperience());
		Dtr.setMobile(DoctorId.getMobile());
		Dtr.setEmail(DoctorId.getEmail());
		Dtr.setConsultationFee(DoctorId.getConsultationFee());
		Dtr.setDepartment(DoctorId.getDepartment());
		Dtr.setAvailbleDays(DoctorId.getAvailbleDays());
		Dtr.setAvailbleTime(DoctorId.getAvailbleTime());
		
		return doctorRepository.save(Dtr);	
		
	}
	
	public ResponseEntity<String> UpdateParticularColumn(Doctor DoctorId, Map<String,Object> DoctorData){
		
		Doctor Dtr = doctorRepository.findById(DoctorId.getDoctorId()).get();
		
		if(Dtr==null) {
			
			return new ResponseEntity<String>("Doctor Id not Found",HttpStatus.NOT_FOUND);
			
		
	    }else {
			
	    	DoctorData.forEach((key,value)->{
				
				  switch (key) {
					
				   case "DoctorId":DoctorId.setDoctorId((Long)value);
				   break;
					
					case "DoctorName":DoctorId.setDoctorName((String)value);
					break;
					
					case "Specialization":DoctorId.setSpecialization((String)value);
					break;
					
					case "Qualification":DoctorId.setQualification((String)value);
					break;
					
					case "Experience": DoctorId.setDoctorId((Long)value);
					break;
					
					case "Mobile":DoctorId.setMobile((String)value);
					break;
				
					case "Email":DoctorId.setEmail((String)value);
					break;
					
					case "ConsultationFee": DoctorId.setConsultationFee((Double)value);
					break;
					
					case "Department":DoctorId.setDepartment((String)value);
					break;
					
					case "AvailbleDays":DoctorId.setAvailbleDays((String)value);
					break;
					
					case "AvailbleTime":DoctorId.setAvailbleTime((String)value);
					break;         
		
					default:
						break;
			       }
		     				
				   });
                  
                   doctorRepository.save(DoctorId);        
    		       return new ResponseEntity<>("Doctor Id Sucessfully updated",HttpStatus.OK);  
	                          
	     	}	
			     
			
			
		}
	
	    public String DeleteDoctor(Long DoctorId){
	    	
	    	
	    	if(!doctorRepository.existsById(DoctorId)) {
				return "Record is not found";
				
			}else {
		    	Doctor Dtr = doctorRepository.findById(DoctorId).get();
				doctorRepository.delete(Dtr);
				
				return "Record Deleted Sucessfully";
			}
			
	    	
	    }
			
		
	}
