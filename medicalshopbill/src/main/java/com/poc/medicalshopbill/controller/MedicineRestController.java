package com.poc.medicalshopbill.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.poc.medicalshopbill.entity.MediDtl;
import com.poc.medicalshopbill.service.MedicineService;
import com.poc.medicalshopbill.vo.MediDropDownRes;
import com.poc.medicalshopbill.vo.MediWrapper;

@RestController
@CrossOrigin
public class MedicineRestController {

	@Autowired
	MedicineService medicineService;
	
	@GetMapping(value="/api/medician/name")
	public List<MediDropDownRes> getMedicianNameList(){
		List<MediDropDownRes> list=new ArrayList<MediDropDownRes>();
		MediDropDownRes mediDropDownRes=null;
		for (MediDtl mediDtl : medicineService.getAllMedi()) {
			mediDropDownRes=new MediDropDownRes();
			mediDropDownRes.setId(mediDtl.getId());
			mediDropDownRes.setMediName(mediDtl.getMedicineName());
			list.add(mediDropDownRes);
		};
		return list;
		
	}
	
	@GetMapping(value="/api/medician")
	public MediDtl getMediById(@RequestParam(name="id") int id){
		MediDtl mediDtl=medicineService.getMediById(id);
		return mediDtl;
		
	}
	
	@PostMapping(value="/api/savemedi")
	public String saveMediDtl(@RequestBody List<MediDtl> mediDtls)
	{
		int[] checkInt=medicineService.saveMedi(mediDtls);
		boolean flag=Arrays.stream(checkInt).allMatch(i->i>0);
		if (flag==true) {
			return "success";
		}else {
			return "error";
		}
		//System.out.println(mediDtls.get(0).getMedicineName());
		
		
	}
	
	
}
