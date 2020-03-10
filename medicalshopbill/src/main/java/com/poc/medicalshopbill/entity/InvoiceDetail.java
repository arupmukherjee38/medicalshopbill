package com.poc.medicalshopbill.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="invoice_dtl_tbl")
public class InvoiceDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "shop_dtl_generator")
	@SequenceGenerator(name="shop_dtl_generator", sequenceName = "SHOP_DTL_SEQ",initialValue = 2, allocationSize = 20)
	@Column(name = "invoice_id", updatable = false, nullable = false)
	private long id;
	
	public void setId(long id) {
		this.id = id;
	}
	
	public long getId() {
		return id;
	}
	
	
}
