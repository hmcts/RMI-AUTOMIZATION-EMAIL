package uk.gov.hmcts.reform.rmi.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uk.gov.hmcts.reform.rmi.dao.EmailAutomizationDAOImpl;
import uk.gov.hmcts.reform.rmi.model.PaymentDTO;


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
	
}
