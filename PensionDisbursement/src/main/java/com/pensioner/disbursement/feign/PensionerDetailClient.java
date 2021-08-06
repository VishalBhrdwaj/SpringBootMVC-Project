package com.pensioner.disbursement.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.pensioner.disbursement.model.PensionerDetail;

@FeignClient(url="${pensionerurl}",name="PensionerDetail")
public interface PensionerDetailClient {
	
	@GetMapping("/pensionerDetailByAadhaar/{aadhaarno}")
	public PensionerDetail getPensionerDetail(@PathVariable("aadhaarno") String aadhaarno);
}
