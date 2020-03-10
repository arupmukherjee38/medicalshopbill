package com.poc.medicalshopbill.dao;

import java.util.List;

import com.poc.medicalshopbill.entity.MediDtl;
import com.poc.medicalshopbill.entity.ShopDetails;

public interface MedicineDao {

	public ShopDetails getShopDtlById();
	public int[] saveMedi(List<MediDtl> dtl);
	public List<MediDtl> getAllMedi();
	public MediDtl getMediById(int id);
}
