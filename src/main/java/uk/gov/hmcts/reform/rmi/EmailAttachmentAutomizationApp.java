package uk.gov.hmcts.reform.rmi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import uk.gov.hmcts.reform.rmi.properties.ApplicationProperties;

@EnableScheduling
@EnableAutoConfiguration
@SpringBootApplication(scanBasePackages={"uk.gov.hmcts.reform.rmi.emailattachment"})
public class EmailAttachmentAutomizationApp implements CommandLineRunner {

	
	@Autowired
	private  ApplicationProperties applicationProperties;
	
	
	public static void main(String[] args) {	
		
		SpringApplication.run(EmailAttachmentAutomizationApp.class);	
	}

	@Override
	public void run(String... arg0) throws Exception {
		System.out.println("The property is: " + applicationProperties.getAccountKey() + ":::::::::::::::::::::::::::;");

		
	}
}
