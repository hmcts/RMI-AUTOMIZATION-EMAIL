package uk.gov.hmcts.reform.rmi.service;

import java.util.List;

import uk.gov.hmcts.reform.rmi.model.BetaCases;
import uk.gov.hmcts.reform.rmi.model.BetaIncident;
import uk.gov.hmcts.reform.rmi.model.CmcCases;
import uk.gov.hmcts.reform.rmi.model.CmcDefence;
import uk.gov.hmcts.reform.rmi.model.CmcJudgement;
import uk.gov.hmcts.reform.rmi.model.DivorceDTO;
import uk.gov.hmcts.reform.rmi.model.PaymentAccountDTO;
import uk.gov.hmcts.reform.rmi.model.PaymentDTO;
import uk.gov.hmcts.reform.rmi.model.ProbateDTO;
import uk.gov.hmcts.reform.rmi.model.ScssDTO;


public interface EmailAutomizationServiceImpl { 
   
	    void cardPaymentFileProcessor(List<PaymentDTO> paymentDTO);
		void divorceFileProcessor(List<DivorceDTO> divorceDTO);
	   	void probateFileProcessor(List<ProbateDTO> probateDTO);
	   	void scssFileProcessor(List<ScssDTO> scssDTO);
	   	void paymentAccountFileProcessor(List<PaymentAccountDTO> paymentAccountDTO);
	   	void betaIncidentFileProcessor(List<BetaIncident> betaIncident);	   	
		void cmcCasesFileProcessor(List<CmcCases> cmcCases);
		void cmcDefenceFileProcessor(List<CmcDefence> cmcDefence);
		void cmcJudgementFileProcessor(List<CmcJudgement> cmcJudgement);
		void betaCasesFileProcessor(List<BetaCases> betaCases);
}
 