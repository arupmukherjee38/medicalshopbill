package com.poc.medicalshopbill.vo;

import java.util.List;

import com.poc.medicalshopbill.entity.MediDtl;

public class MediWrapper {

	List<MediDtl> mediDtls;
	
	public void setMediDtls(List<MediDtl> mediDtls) {
		this.mediDtls = mediDtls;
	}
	
	public List<MediDtl> getMediDtls() {
		return mediDtls;
	}
}
