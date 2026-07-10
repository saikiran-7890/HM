package com.kiran.www.dto;

//import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StaffRequest {


	
	@NotNull(message = "Staff Name mandatory")
	private String StaffName;
	
	@NotNull(message = "Staff Role mandatory")
	private String StaffRole;
	
    @Pattern(regexp = "^\\d{10}",message = "Mobile Number Should 10-Digits & Mandatory")
	private String Mobile;
	
	@NotNull(message = "Email should mandatory")
	private String Email;
	
	@NotNull(message = "Salary Must In Decimal")
	private Double Salary;	
	
	@NotNull(message = "Join Date mandatory")	
	private String JoinDate;
}
