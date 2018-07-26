package uk.gov.hmcts.reform.rmi.scheduledTask;



import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import uk.gov.hmcts.reform.rmi.model.PaymentDTO;
import uk.gov.hmcts.reform.rmi.service.EmailAutomizationServiceImpl;
import uk.gov.hmcts.reform.rmi.service.FindFileInContainer;



@Component
public class CardPaymentFileProcessorTask {
	
	private static final Logger logger = LoggerFactory.getLogger(CardPaymentFileProcessorTask.class);
	
	@Autowired
	private FindFileInContainer findfileInContainer;
	
	@Autowired
	private EmailAutomizationServiceImpl emailAutomizationService;
	
	
	@Scheduled(cron = "0 0 14 * * ?", zone="Europe/London")
	public void processCardPaymentFile() {
			
		String fileName = findfileInContainer.retunFileName("hmcts_card_payments");
		ByteArrayInputStream filedata = null;
		
		
		if (!fileName.equals("NOT_FOUND")) {
			filedata  = findfileInContainer.retunFileData(fileName);
			
			try (BufferedReader brr = new BufferedReader(new InputStreamReader(filedata, "UTF-8"))) {	
				
				List<PaymentDTO> paymentDTO = brr.lines().skip(1).map(mapToItem).collect(Collectors.toList());				
				logger.info("Total Record Found in Card Payment file:: " +paymentDTO.size());
				
				emailAutomizationService.cardPaymentFileProcessor(paymentDTO);
				
			} catch (IOException e) {
				logger.info("Found error while reading data from Card Payment FIle:: " + e.getStackTrace());	
			}
			
			
		} else {			
			logger.info("No file found for Payment in container");
		}
		
		
	}
	
	private static Function<String, PaymentDTO> mapToItem = (line) -> {
			
		  String[] p = line.split(",");
		  PaymentDTO items = new PaymentDTO(p[0], p[1], p[2], p[3],  p[4], p[5], p[6], p[7], p[8], p[9], Double.parseDouble(p[10]), p[11], p[12], p[13], Double.parseDouble(p[14]), p[15], p[16], p[17]);		  
		  return items;
	};
	
}
