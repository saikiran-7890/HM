package com.kiran.www.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.kiran.www.entity.Appointment;
import com.kiran.www.repository.AppointmentRepository;

@Service
public class AppointmentService {
	
	@Autowired
	private AppointmentRepository appointmentRepository;
	
	public Appointment BookAppointment(Appointment appointment){
			
		return appointmentRepository.save(appointment);
	
	}
	
	public Appointment UpdateAppointment(Appointment appointment) {
		
		Appointment apt = appointmentRepository.findById(appointment.getAppiontmentId()).get();
		
		apt.setAppiontmentTime(appointment.getAppiontmentTime());
		apt.setAppointmentDate(appointment.getAppointmentDate());
		apt.setDoctorId(appointment.getDoctorId());
		apt.setPatientId(appointment.getPatientId());
		apt.setReason(appointment.getReason());
		apt.setStatus(appointment.getStatus());
		
		return appointmentRepository.save(apt);	
		
	}
	
	public String CancelAppointment(Long aapointmentId){
		
		
		
		if(!appointmentRepository.existsById(aapointmentId)) {
			
			return "Appointment  ID Is Not Found";
			
			
		}else {
			Appointment apt =  appointmentRepository.findById(aapointmentId).get();
			appointmentRepository.delete(apt);


			return ("Appointment Canceld Due to doctor is in Operation theater Meet Next Day Morning 10:AM Sharp");
		
		}
		
		
	}
	
	public List<Appointment> GetAllAppointments(Appointment appointment){
		
		return appointmentRepository.findAll();
		
	}
	

}
