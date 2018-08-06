package uk.gov.hmcts.reform.rmi.model;

public class CmcJudgement {
	private String requestedDate;
	private String payDetail;
	private String populationConfirmation;
	private String errorsEncountered;
	/**
	 * @return the requestedDate
	 */
	public String getRequestedDate() {
		return requestedDate;
	}
	/**
	 * @param requestedDate the requestedDate to set
	 */
	public void setRequestedDate(String requestedDate) {
		this.requestedDate = requestedDate;
	}
	/**
	 * @return the payDetail
	 */
	public String getPayDetail() {
		return payDetail;
	}
	/**
	 * @param payDetail the payDetail to set
	 */
	public void setPayDetail(String payDetail) {
		this.payDetail = payDetail;
	}
	/**
	 * @return the populationConfirmation
	 */
	public String getPopulationConfirmation() {
		return populationConfirmation;
	}
	/**
	 * @param populationConfirmation the populationConfirmation to set
	 */
	public void setPopulationConfirmation(String populationConfirmation) {
		this.populationConfirmation = populationConfirmation;
	}
	/**
	 * @return the errorsEncountered
	 */
	public String getErrorsEncountered() {
		return errorsEncountered;
	}
	/**
	 * @param errorsEncountered the errorsEncountered to set
	 */
	public void setErrorsEncountered(String errorsEncountered) {
		this.errorsEncountered = errorsEncountered;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CmcJudgement [requestedDate=" + requestedDate + ", payDetail=" + payDetail + ", populationConfirmation="
				+ populationConfirmation + ", errorsEncountered=" + errorsEncountered + ", getRequestedDate()="
				+ getRequestedDate() + ", getPayDetail()=" + getPayDetail() + ", getPopulationConfirmation()="
				+ getPopulationConfirmation() + ", getErrorsEncountered()=" + getErrorsEncountered() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	public CmcJudgement() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
