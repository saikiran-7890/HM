package com.kiran.www.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name="Medicine")
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class Medicine {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long MedicineId;
	@Column
	private String MedicineName;
	@Column
	private String Manfacturer;
	@Column
	private String Quantity;
	@Column
	private Double Price;
	@Column
	private LocalDate ExpieryDate;
	@Column
	private String StockStatus;
	

}
