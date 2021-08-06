package com.pension.process.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pension.process.model.PensionDetail;
import com.pension.process.model.PensionerInput;
import com.pension.process.model.ProcessPensionInput;
import com.pension.process.service.ProcessPension;

@RestController
public class ProcessPensionController {
	@Autowired
	private ProcessPension processPension;
	
	@GetMapping("/pensionDetail")
	public PensionDetail getPensionDetail(@ModelAttribute PensionerInput pensionerInputObj)
	{
		return processPension.getPensionDetail(pensionerInputObj);
	}
	
	@PostMapping("/processPension")
	public int processPension(@RequestBody ProcessPensionInput processPensionInputObj)
	{
		return processPension.processPension(processPensionInputObj);
	}

}
