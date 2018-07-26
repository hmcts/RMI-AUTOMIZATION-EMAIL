package uk.gov.hmcts.reform.rmi.service;

import java.util.List;

import uk.gov.hmcts.reform.rmi.model.PaymentDTO;


public interface EmailAutomizationServiceImpl { 
   
	 void cardPaymentFileProcessor(List<PaymentDTO> paymentDTO);
    
}
 