package com.pension.process.service;

import com.pension.process.model.PensionDetail;
import com.pension.process.model.PensionerInput;
import com.pension.process.model.ProcessPensionInput;

public interface ProcessPension {
	public PensionDetail getPensionDetail(PensionerInput pensionerInput);
	public int processPension(ProcessPensionInput processPensionInput);
	public double pensionAmount(double salayEarned,String pensionType,String bankType);
}
