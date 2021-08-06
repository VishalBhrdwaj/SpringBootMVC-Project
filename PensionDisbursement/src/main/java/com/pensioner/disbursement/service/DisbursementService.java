package com.pensioner.disbursement.service;

import com.pensioner.disbursement.model.PensionerDetail;
import com.pensioner.disbursement.model.ProcessPensionInput;

public interface DisbursementService {

	public int getDisbursePension(ProcessPensionInput processPensionInputObj);

}
