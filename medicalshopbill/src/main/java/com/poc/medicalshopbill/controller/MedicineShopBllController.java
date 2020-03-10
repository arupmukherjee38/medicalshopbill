package com.poc.medicalshopbill.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.poc.medicalshopbill.entity.MediDtl;
import com.poc.medicalshopbill.service.MedicineService;
import com.poc.medicalshopbill.vo.MediWrapper;

@Controller
public class MedicineShopBllController {

	
	@Autowired
	MedicineService medicineService;
	
	
	@GetMapping(value="/")
	public String home(HttpServletRequest request){
	
	   request.setAttribute("shop", medicineService.getShopDtlById());
	   return "index";
	}
	
	@GetMapping(value="/uploadfrom")
	public String getUploadFrom()
	{
		
		return "upload";
		
	}
	
	
	@GetMapping(value="/update")
	public String getUpdate(HttpServletRequest request)
	{
		request.setAttribute("mediDtls", medicineService.getAllMedi());
		return "update";
		
	}
	
	/*@PostMapping(value="/savemedi")
	public String saveMediDtl(@RequestBody MediWrapper mediWrapper,HttpServletRequest request)
	{
		int[] checkInt=medicineService.saveMedi(mediWrapper.getMediDtls());
		boolean flag=Arrays.stream(checkInt).allMatch(i->i>0);
		if (flag==true) {
			request.setAttribute("mediDtls", medicineService.getAllMedi());
		}else {
			request.setAttribute("mediDtls", new ArrayList<MediDtl>());
		}
		return "update";
		
	}*/
	
	
}
