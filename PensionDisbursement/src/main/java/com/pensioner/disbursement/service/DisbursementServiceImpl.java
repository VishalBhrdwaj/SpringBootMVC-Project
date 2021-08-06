package com.pensioner.disbursement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pensioner.disbursement.feign.PensionerDetailClient;
import com.pensioner.disbursement.model.PensionerDetail;
import com.pensioner.disbursement.model.ProcessPensionInput;

@Service
public class DisbursementServiceImpl implements DisbursementService{

	@Autowired
	private PensionerDetailClient pensionerDetailClient;
	public double pensionAmount(double salayEarned,String pensionType,String bankType,double allowances)
	{
		double pensionAmount=0.0;
		if(pensionType.toLowerCase().equals("self"))
		{
			pensionAmount=(80*salayEarned)/100;
		}
		else
		{
			pensionAmount=(50*salayEarned)/100;
		}
		
		if(bankType.toLowerCase().equals("public"))
			pensionAmount+=500;
		else
			pensionAmount+=550;
		
		return pensionAmount+allowances;
	}
	
	public int getDisbursePension(ProcessPensionInput processPensionInputObj)
	{
		PensionerDetail pensionerDetail=pensionerDetailClient.getPensionerDetail(processPensionInputObj.getAadhaarNo());
		
		Double pensionAmount=pensionAmount(pensionerDetail.getSalaryearned(),
				pensionerDetail.getPensiontype(),
				pensionerDetail.getPublicorprivate(),
				Double.parseDouble(pensionerDetail.getAllowances()));
		if(pensionAmount==processPensionInputObj.getPensionAmount())
		{
			return 1;
		}
			
		return 0;
	}
	

}
