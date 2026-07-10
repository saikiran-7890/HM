package com.kiran.www.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "build")
public class BillingRequest {
	
	
    @NotNull(message = "Enter Cosultation Fee Required")
	private Double ConsultationFee;
    
    @NotNull(message = "Enter Medicine Charge ")
    private Double MedicineCharge;
    
    @NotNull(message = "Room Cahrge is mandatory")
	private Double RoomCharge;
    
    @NotNull(message = "Lab Charge is mandatory")
	private Double LabCharge;
    
    @NotNull(message = "Enter the Total amount")
	private Double TotalAmount;
    
    @NotNull(message = "Payment Status Required")
	private String PaymentStatus;
    
    @NotNull(message = "Payment time Should mandatory")
	private LocalDate PaymentDate;

}
