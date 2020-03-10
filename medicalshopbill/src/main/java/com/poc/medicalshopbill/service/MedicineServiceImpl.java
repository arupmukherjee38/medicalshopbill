package com.poc.medicalshopbill.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poc.medicalshopbill.dao.MedicineDao;
import com.poc.medicalshopbill.entity.MediDtl;
import com.poc.medicalshopbill.entity.ShopDetails;

@Service
public class MedicineServiceImpl implements MedicineService{

	
	@Autowired
	MedicineDao medicineDao;
	
	@Override
	public ShopDetails getShopDtlById() {
		return medicineDao.getShopDtlById();
	}

	@Override
	public int[] saveMedi(List<MediDtl> dtl) {
		// TODO Auto-generated method stub
		return medicineDao.saveMedi(dtl);
	}

	@Override
	public List<MediDtl> getAllMedi() {
		// TODO Auto-generated method stub
		return medicineDao.getAllMedi();
	}

	@Override
	public MediDtl getMediById(int id) {
		// TODO Auto-generated method stub
		return medicineDao.getMediById(id);
	}

}
