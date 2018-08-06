package uk.gov.hmcts.reform.rmi.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uk.gov.hmcts.reform.rmi.dao.EmailAutomizationDAOImpl;
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


@Service
public class EmailAutomizationService implements EmailAutomizationServiceImpl {
	
	@Autowired
	private EmailAutomizationDAOImpl emailAutomizationDAO;
	
	private static final Logger logger = LoggerFactory.getLogger(EmailAutomizationService.class);
	
	
	@Override
	public void cardPaymentFileProcessor(List<PaymentDTO> paymentDTO){
		try {
				logger.info("EmailAutomizationService::cardPaymentFileProcessor::Start"); 
				
				emailAutomizationDAO.cardPaymentFileProcessor((paymentDTO));
				
				logger.info("EmailAutomizationService::cardPaymentFileProcessor::End"); 	
				
		}catch(Exception e) {
				logger.error("EmailAutomizationService::cardPaymentFileProcessor::There is some problem calling service"); 		
				logger.error("Error while calling Data Access layer: ", e);
								
		}
	}
	
	@Override
	public void divorceFileProcessor(List<DivorceDTO> divorceDTO){
		try {
				logger.info("EmailAutomizationService::divorceFileProcessor::Start"); 
				
				emailAutomizationDAO.divorceFileProcessor((divorceDTO));
				
				logger.info("EmailAutomizationService::divorceFileProcessor::End"); 	
				
		}catch(Exception e) {
				logger.error("EmailAutomizationService::divorceFileProcessor::There is some problem calling service"); 		
				logger.error("Error while calling Data Access layer: ", e);
								
		}
	}
	
	@Override
	public void probateFileProcessor(List<ProbateDTO> probateDTO){
		try {
				logger.info("EmailAutomizationService::probateFileProcessor::Start"); 
				
				emailAutomizationDAO.probateFileProcessor((probateDTO));
				
				logger.info("EmailAutomizationService::probateFileProcessor::End"); 	
				
		}catch(Exception e) {
				logger.error("EmailAutomizationService::probateFileProcessor::There is some problem calling service"); 		
				logger.error("Error while calling Data Access layer: ", e);
								
		}
	}
	
	
	@Override
	public void scssFileProcessor(List<ScssDTO> scssDTO){
		try {
				logger.info("EmailAutomizationService::scssFileProcessor::Start"); 
				
				emailAutomizationDAO.scssFileProcessor((scssDTO));
				
				logger.info("EmailAutomizationService::scssFileProcessor::End"); 	
				
		}catch(Exception e) {
				logger.error("EmailAutomizationService::scssFileProcessor::There is some problem calling service"); 		
				logger.error("Error while calling Data Access layer: ", e);
								
		}
	}	
		
	@Override
	public void paymentAccountFileProcessor(List<PaymentAccountDTO> paymentAccountDTO){
			try {
					logger.info("EmailAutomizationService::paymentAccountFileProcessor::Start"); 
					
					emailAutomizationDAO.paymentAccountFileProcessor((paymentAccountDTO));
					
					logger.info("EmailAutomizationService::paymentAccountFileProcessor::End"); 	
					
			}catch(Exception e) {
					logger.error("EmailAutomizationService::paymentAccountFileProcessor::There is some problem calling service"); 		
					logger.error("Error while calling Data Access layer: ", e);
									
			}
	}
	
	@Override
	public void betaIncidentFileProcessor(List<BetaIncident> betaIncident){
			try {
					logger.info("EmailAutomizationService::betaIncidentFileProcessor::Start"); 
					
					emailAutomizationDAO.betaIncidentFileProcessor((betaIncident));
					
					logger.info("EmailAutomizationService::paymentAccountFileProcessor::End"); 	
					
			}catch(Exception e) {
					logger.error("EmailAutomizationService::betaIncidentFileProcessor::There is some problem calling service"); 		
					logger.error("Error while calling Data Access layer: ", e);
									
			}
	}
	
	
	
	@Override
	public void cmcCasesFileProcessor(List<CmcCases> cmcCases) {
		try {
			logger.info("EmailAutomizationService::cmcCasesFileProcessor::Start"); 
			
			emailAutomizationDAO.cmcCasesFileProcessor((cmcCases));
			
			logger.info("EmailAutomizationService::cmcCasesFileProcessor::End"); 	
			
		}catch(Exception e) {
			logger.error("EmailAutomizationService::cmcCasesFileProcessor::There is some problem calling service"); 		
			logger.error("Error while calling Data Access layer: ", e);							
		}
	}
	
	@Override
	public void cmcDefenceFileProcessor(List<CmcDefence> cmcDefence) {
		try {
			logger.info("EmailAutomizationService::cmcDefenceFileProcessor::Start"); 
			
			emailAutomizationDAO.cmcDefenceFileProcessor((cmcDefence));
			
			logger.info("EmailAutomizationService::cmcCasesFileProcessor::End"); 	
			
		}catch(Exception e) {
			logger.error("EmailAutomizationService::cmcDefenceFileProcessor::There is some problem calling service"); 		
			logger.error("Error while calling Data Access layer: ", e);							
		}	
	}
	@Override
	public void cmcJudgementFileProcessor(List<CmcJudgement> cmcJudgement) {
		try {
			logger.info("EmailAutomizationService::cmcJudgementFileProcessor::Start"); 
			
			emailAutomizationDAO.cmcJudgementFileProcessor((cmcJudgement));
			
			logger.info("EmailAutomizationService::cmcCasesFileProcessor::End"); 	
			
		}catch(Exception e) {
			logger.error("EmailAutomizationService::cmcJudgementFileProcessor::There is some problem calling service"); 		
			logger.error("Error while calling Data Access layer: ", e);							
		}
	}
	
	@Override
	public void betaCasesFileProcessor(List<BetaCases> betaCases) {
		try {
			logger.info("EmailAutomizationService::betaCasesFileProcessor::Start"); 
			
			emailAutomizationDAO.betaCasesFileProcessor((betaCases));
			
			logger.info("EmailAutomizationService::betaCasesFileProcessor::End"); 	
			
		}catch(Exception e) {
			logger.error("EmailAutomizationService::betaCasesFileProcessor::There is some problem calling service"); 		
			logger.error("Error while calling Data Access layer: ", e);							
		}
	}
}
