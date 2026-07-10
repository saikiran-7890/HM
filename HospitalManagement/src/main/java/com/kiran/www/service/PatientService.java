package com.kiran.www.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.kiran.www.entity.Patient;
import com.kiran.www.exceptions.DuplicateRecordException;
import com.kiran.www.exceptions.ResourceNotFoundException;
import com.kiran.www.repository.PatientRepository;

@Service
public class PatientService {
	
	@Autowired
	private PatientRepository patientRepository;
	
	public String addPatient(Patient patient) {
		
	   if(patientRepository.existsByEmail(patient.getEmail())) {
		   
		   throw new DuplicateRecordException("patien email already exists");
		   
	   }
		
		patientRepository.save(patient);
		return "patient added";
		
	}
	
	public Patient GetPatient(Long patientId) {
		
	     return patientRepository.findById(patientId).get();
		
	}
	
	public List<Patient>GetAllPatients(Long patientId) {
		
		return patientRepository.findAll();
		
	}
	
	public Patient UpdatePatient(Patient patientId) {
		
		Patient pnt = patientRepository.findById(patientId.getPatientId()).orElseThrow(()-> new ResourceNotFoundException("Patient Id not found"));
		pnt.setBloodGroup(patientId.getBloodGroup());
		pnt.setDisease(patientId.getDisease());
		pnt.setAddress(patientId.getAddress());
		pnt.setCity(patientId.getCity());
		
		return patientRepository.save(pnt);	
		
	}
	
	public ResponseEntity<String> UpdateParticularName(Patient patient,Map<String,Object>Data) {
		
		Patient pnt = patientRepository.findById(patient.getPatientId()).orElseThrow(()-> new ResourceNotFoundException("Patient Id not found"));
		
		if(pnt==null) {
			
			return new ResponseEntity<>("Patient Id not found",HttpStatus.NOT_FOUND);
			
		}else {
				
			Data.forEach((key,value)->{
				
		     switch (key) {
			 case "PatientId":patient.setPatientId((Long)value);
			 break;
			 
			 case "FirstName":patient.setFirstName((String)value);
			 break;
			 
			 case "LastName":patient.setLastName((String)value);
			 break;
			 
			 case "Gender":patient.setGender((String)value);
			 break;
			 
			 case "Age":patient.setAge((Integer)value);
			 break;
			 
			 case "DOB":patient.setDOB((String)value);
			 break;
			 
			 case "BloodGroup":patient.setBloodGroup((String)value);
			 break;
			 
			 case "Mobile":patient.setMobile((String)value);
			 break;
			 
			 case "Address":patient.setAddress((String)value);
			 break;
			 
			 case "City":patient.setCity((String)value);
			 break;
			 
			 case "State":patient.setState((String)value);
			 break;
			 
			 case "EmergencyContact":patient.setEmergencyContact((String)value);
			 break;
			 
			 case "Disease":patient.setDisease((String)value);
			 break;
			 
			 case "AdmitedDate":patient.setAdmitedDate((LocalDate)value);
			 break;
			 
			 case "DischargeDate":patient.setDischargeDate((LocalDate)value);
			 break;
			
			 case "Status":patient.setStatus((String)value);
			 break;

			default:
				break;
			}
				
				
			});
	
	        patientRepository.save(patient);
	        return new ResponseEntity<>("Patient record Sucessfully updated",HttpStatus.OK);
		  
		}		

		
	}
	public String DeletePatient(Long PatientId){
		
		if(!patientRepository.existsById(PatientId)) {
			return "Record is not found";
			
		}else {
			Patient pnt= patientRepository.findById(PatientId).get();
			patientRepository.delete(pnt);
			
			return "Record Deleted Sucessfully";
		}
		
	}
}
