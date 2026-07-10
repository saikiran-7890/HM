package com.kiran.www.entity;

import com.kiran.www.enums.StaffInformation;

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
@Table(name="Staff")
@AllArgsConstructor
@NoArgsConstructor
public class Staff {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long staffId;
	@Column
	private String StaffName;
	@Column
	private String StaffRole;
	@Column
	private String Mobile;
	@Column
	private String email;
	@Column
	private Double Salary;
	@Column
	private String JoinDate;
	
	@Enumerated(EnumType.STRING)
	
	private StaffInformation staffInformation;

}
