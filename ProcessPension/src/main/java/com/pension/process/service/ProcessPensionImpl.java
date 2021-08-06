package com.pension.process.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pension.process.feign.PensionDisbursementClient;
import com.pension.process.feign.PensionerDetailClient;
import com.pension.process.model.PensionDetail;
import com.pension.process.model.PensionerDetail;
import com.pension.process.model.PensionerInput;
import com.pension.process.model.ProcessPensionInput;

@Service
public class ProcessPensionImpl implements ProcessPension {
	
	@Autowired
	private PensionerDetailClient pensionerDetailClient;
	
	@Autowired
	private PensionDisbursementClient pensionDisbursementClient;
	
	@Override
	public double pensionAmount(double salayEarned,String pensionType,String bankType)
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
		
		return pensionAmount;
	}
	
	@Override
	public PensionDetail getPensionDetail(PensionerInput pensionerInputObj){ 
		PensionerDetail pensionerDetail=pensionerDetailClient.getPensionerDetail(pensionerInputObj.getAadhaarNo());
		
		PensionDetail pensionDetailObj=new PensionDetail();
		pensionDetailObj.setName(pensionerDetail.getName());
		pensionDetailObj.setPan(pensionerDetail.getPan());
		pensionDetailObj.setDateOfBirth(pensionerDetail.getDateofbirth());
		pensionDetailObj.setPensionType(pensionerDetail.getPensiontype());	
		double pensionAmount=pensionAmount(pensionerDetail.getSalaryearned(), pensionerDetail.getPensiontype(), pensionerDetail.getPublicorprivate());
		pensionDetailObj.setPensionAmount(pensionAmount+Double.parseDouble(pensionerDetail.getAllowances()));
		return pensionDetailObj;
	}

	@Override
	public int processPension(ProcessPensionInput processPensionInputObj){
		return pensionDisbursementClient.getDisbursePension(processPensionInputObj);
	}
}
