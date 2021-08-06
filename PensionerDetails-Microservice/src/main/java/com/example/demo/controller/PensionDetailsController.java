package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.model.PensionDetail;
import com.example.demo.service.PensionService;

@RestController
public class PensionDetailsController {
	
	@Autowired
	PensionService ee;

	@GetMapping(value="/pensionerDetailByAadhaar/{aadhaarno}")
	public ResponseEntity<PensionDetail> getEmpById( @PathVariable("aadhaarno") String aadhaarno){
		PensionDetail pensionDetailObj=ee.getPension(aadhaarno);
		if(pensionDetailObj!=null) {
			return new ResponseEntity<PensionDetail>(pensionDetailObj, HttpStatus.OK);
		}
		else {
			pensionDetailObj = new PensionDetail();
			pensionDetailObj.setName("Pension not present");
			return new ResponseEntity<PensionDetail>(pensionDetailObj, HttpStatus.FORBIDDEN);
		}
	}
	
	
}
