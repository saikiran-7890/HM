package com.kiran.www.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DoctorRequest {

	
	@NotNull(message = "Enter Doctor Name")
	private String DoctorName;
	
	@NotNull(message = "Enter Specialization ")
	private String Specialization;
	
	@NotNull(message = "Enter Qualification")
	private String Qualification;
	
	@NotNull(message = " Experience should be mandatory")
	private String Experience;
	
	@Pattern(regexp = "^\\d{10}",message=" Enter Mobile number is Invalid & number should  be 10 digits mandatory")
	private String Mobile;
	
	@NotNull(message = "Email mandatory")
	private String Email;
	
	@NotNull(message = "Cosultation fee mandatory")
	private Double ConsultationFee;
	
	@NotNull(message = "Department mandator")
	private String Department;
	
	@NotNull(message = "Enter availble days mandatory")
	private String AvailbleDays;
	
	@NotNull(message = "Enter availble days mandatory")
	private String AvailbleTime;

}
