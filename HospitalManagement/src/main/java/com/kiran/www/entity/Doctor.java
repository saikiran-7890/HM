package com.kiran.www.entity;

import com.kiran.www.enums.DoctorInformation;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name="doctor")
@AllArgsConstructor
@NoArgsConstructor
public class Doctor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Long doctorId;	
	
	@NotNull(message = "Enter Doctor Name")
	private String DoctorName;
	
	@NotNull(message = "Enter Specialization ")
	private String Specialization;
	
	@NotNull(message = "Enter Qualification")
	private String Qualification;
	private String Experience;
	
	@Pattern(regexp = "^\\d{10}",message=" Enter Mobile number is Invalid & number should  be 10 digits mandatory")
	private String Mobile;
	
	@NotNull(message = "Email mandatory")
	private String email;
	private Double ConsultationFee;
	private String Department;	
	private String AvailbleDays;	
	private String AvailbleTime;
	
	@Enumerated(EnumType.STRING)
	
	private DoctorInformation doctorinformation;
	
	
	
	

}
