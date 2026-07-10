package com.kiran.www.entity;

import java.time.LocalDate;

import com.kiran.www.enums.AppointimentStatus;

//import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name="appointment")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Appointment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long AppiontmentId;
	private Long PatientId;	
	private Long DoctorId;
	@NotNull(message = "AppointDate is Required & mandatory")
	private LocalDate AppointmentDate;
	private String AppiontmentTime;
	private String Reason;
	private String Status;
	
	
	
	@Enumerated(EnumType.STRING)
	private  AppointimentStatus apppointimentStatus;
	
	 
     
     
	


}
