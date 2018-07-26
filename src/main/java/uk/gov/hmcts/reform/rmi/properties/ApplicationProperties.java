package uk.gov.hmcts.reform.rmi.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "app")
@Component 
public class ApplicationProperties {
	
    private String accountName;
    private String accountKey;
	/**
	 * @return the accountName
	 */
	public String getAccountName() {
		return accountName;
	}
	/**
	 * @param accountName the accountName to set
	 */
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	/**
	 * @return the accountKey
	 */
	public String getAccountKey() {
		return accountKey;
	}
	/**
	 * @param accountKey the accountKey to set
	 */
	public void setAccountKey(String accountKey) {
		this.accountKey = accountKey;
	}

    
}
