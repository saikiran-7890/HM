package com.kiran.www.dto;

import java.time.LocalDate;

//import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "build")
public class MedicineRequest {
	
	
	
    @NotNull(message = "Medicine Name Required")
	private String MedicineName;
    
    @NotNull(message = "Manfacture Company Required")
	private String Manfacturer;
    
    @NotNull(message = "Enter Medicine Quantity")
	private String Quantity;
    
    @NotNull(message = "Price is Mandatory")
	private Double Price;
    
    @NotNull(message = "Enter Expiery Date")
	private LocalDate ExpieryDate;
    
    @NotNull(message = "Enter Stock Status")
	private String StockStatus;
	


}
