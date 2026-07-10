package com.kiran.www.entity;

import java.time.LocalDate;

import com.kiran.www.enums.PatientInformation;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name="Patient")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Patient {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long patientId;

    @NotNull(message = "Name is mandatory")
    private String FirstName;
	@Column
	private String LastName;
	@Column
	private String Gender;
  
	@Min(1)
	@Max(100)
	private Integer Age;
	private String DOB;
	
	@NotNull(message = "Blood Group Mandatory")
	private String BloodGroup;
	@Pattern(regexp = "^\\d{10}",message = "Mobile number should be 10 digits & mandatory")
	private String Mobile;
	
	@Column(unique=true)
	private String email;
	
	@NotNull(message = "Address is Mandatory")
	private String Address;
	@NotNull(message = "City is Mandatory")
	private String City;
	@NotNull(message = "State is Mandatory")
	private String State;
	@NotNull(message = "Pincode is Mandatory")
	private String Pincode;
	@Column
	private String EmergencyContact;
	@Column
	private String Disease;
	@Column
	private LocalDate AdmitedDate;
	@Column
	private LocalDate DischargeDate;
	@Column
	private String Status;
	
	@Enumerated(EnumType.STRING)
	private PatientInformation patientInformation;


}
