package com.kiran.www.dto;

import java.time.LocalDate;

//import jakarta.persistence.Column;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "build")
public class PatientRequest {
	
    @NotNull(message = "Name is mandatory")
	private String FirstName;
    
    @Null
    private String LastName;
    
    @NotNull(message = "gender is mandatory")
	private String Gender;
    
	@Min(10)
    @Max(70)
	private Integer Age;
	
	@NotNull(message = "Date of Birth is mandatory")
	private String DOB;
	
	@NotNull(message = "Blood Group Mandatory")
	private String BloodGroup;
	
	@Pattern(regexp = "^\\d{10}",message = "Mobile number is 10-digits & mandatory")
	private String Mobile;
	
	@NotNull(message = "Email is Mandatory to connect Online with Doctor")
	private String Email;
	@NotNull
	private String Address;	
	@NotNull
	private String City;
	@NotNull(message = "State is mandatory")
	private String State;
	
	@NotNull(message = "Picode is mandatory")
	private String Pincode;
	
	@NotNull(message = "Emergency details is mandatory")
	private String EmergencyContact;
	
	@NotNull(message = "Disease is mandatory")
	private String Disease;
	
	@NotNull(message = "Admit date is mandatory")
	private LocalDate AdmitedDate;
	
	@NotNull(message = "Discharge date is mandatory")
	private LocalDate DischargeDate;
	
	@NotNull(message = "Status is mandatory")
	private String Status;

}
