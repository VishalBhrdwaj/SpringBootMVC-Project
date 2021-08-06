package com.pension.process.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.pension.process.model.PensionerDetail;
import com.pension.process.model.ProcessPensionInput;


@FeignClient(url="${PensionDisbursementURL}",name="PensionDisbursement")
public interface PensionDisbursementClient {
	
	@PostMapping("/disbursePension")
	public int getDisbursePension (@RequestBody ProcessPensionInput processPensionInput);
}
