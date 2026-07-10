package com.kiran.www.entity;

import java.time.LocalDate;

import com.kiran.www.enums.PaymentInformation;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity

@Data
@Table(name="billing")
@AllArgsConstructor
@NoArgsConstructor


public class Billing {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long BillId;
   @Column
	private Integer PatientId;
	@Column
	private Double ConsultationFee;
	@Column
	private Double MedicineCharge;
	@Column
	private Double RoomCharge;
	@Column
	private Double LabCharge;
	@Column
	private Double TotalAmount;
	@Column
	private String PaymentStatus;
	@Column
	private LocalDate PaymentDate;
	
	
	@Enumerated(EnumType.STRING)	
	
	private PaymentInformation PaymentInformation;
	

}
