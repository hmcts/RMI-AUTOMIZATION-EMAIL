package uk.gov.hmcts.reform.rmi.dao;

import java.util.List;

import uk.gov.hmcts.reform.rmi.model.PaymentDTO;

public interface EmailAutomizationDAOImpl {
   
   	void cardPaymentFileProcessor(List<PaymentDTO> paymentDTO);
}
 