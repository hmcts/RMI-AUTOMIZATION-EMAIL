package uk.gov.hmcts.reform.rmi;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

@EnableScheduling
@EnableAutoConfiguration
@SpringBootApplication(scanBasePackages={"uk.gov.hmcts.reform.rmi"})
public class EmailAttachmentAutomizationApp {
	
	
	public static void main(String[] args) {			
		SpringApplication.run(EmailAttachmentAutomizationApp.class);	
	}
	
	@Bean
	 public TaskScheduler ScheduledTaskService(){
	    return new ThreadPoolTaskScheduler();
	 }
}
