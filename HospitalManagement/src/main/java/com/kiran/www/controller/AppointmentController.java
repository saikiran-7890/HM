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

import com.kiran.www.entity.Appointment;
import com.kiran.www.service.AppointmentService;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/appointment")
public class AppointmentController {
	
	@Autowired
	private AppointmentService appointmentService;
	
	@PostMapping("/add")
	public Appointment BookAppointment(@RequestBody  @Valid Appointment appointment) {
		
		return appointmentService.BookAppointment(appointment);
		
	}
	
	@PutMapping("/update/{appointmentId}")
        public Appointment UpdateAppointment(@RequestBody Appointment appointment) {
		
		return appointmentService.UpdateAppointment(appointment);
		
	}
	
	@DeleteMapping("/cancel/{appointmentId}")
	public String CancelAppointment(@PathVariable Long appointmentId){
		
		return appointmentService.CancelAppointment(appointmentId);
		
	}
	
	@GetMapping("/all")
	public List<Appointment>GetAllAppointments(Appointment appointment) {
		
		return appointmentService.GetAllAppointments(appointment);
	}

}
