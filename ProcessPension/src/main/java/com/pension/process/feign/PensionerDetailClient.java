package com.pension.process.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.pension.process.model.PensionerDetail;


@FeignClient(url="${pensionerurl}",name="PensionerDetail")
public interface PensionerDetailClient {
	
	@GetMapping("/pensionerDetailByAadhaar/{aadhaarno}")
	public PensionerDetail getPensionerDetail(@PathVariable("aadhaarno") String aadhaarno);
}
