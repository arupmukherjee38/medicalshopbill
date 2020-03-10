package com.poc.medicalshopbill.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="medi_dtl_tbl")
public class MediDtl {

	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "medi_dtl_generator")
	@SequenceGenerator(name="medi_dtl_generator", sequenceName = "MEDI_DTL_SEQ" ,initialValue = 1, allocationSize = 1)
	@Column(columnDefinition = "number")
	private int id;
	
	@Column(columnDefinition = "varchar(500)")
	private String medicineName;
	
	@Column(columnDefinition = "varchar(500)")
	private String batchNo;
	
	@Column(columnDefinition = "varchar(500)")
	private String expireDate;
	
	@Column(columnDefinition = "number")
	private double price;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMedicineName() {
		return medicineName;
	}

	public void setMedicineName(String medicineName) {
		this.medicineName = medicineName;
	}

	public String getBatchNo() {
		return batchNo;
	}

	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}

	public String getExpireDate() {
		return expireDate;
	}

	public void setExpireDate(String expireDate) {
		this.expireDate = expireDate;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	
	
	
	
}
