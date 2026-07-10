package com.kiran.www.dto;

import java.time.LocalDate;


import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "build")
public class AppointimentRequest {
	
	
    @NotNull(message = "AppointDate is Required & mandatory")
	private LocalDate AppointmentDate;
	@NotNull(message = "AppointTime is Required & mandatory")
	private String AppiontmentTime;
    @NotNull(message = "Reason Should mandatory")
	private String Reason;
    @NotNull(message = "Status is mandatory")
	private String Status;



}
