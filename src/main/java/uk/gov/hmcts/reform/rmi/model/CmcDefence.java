package uk.gov.hmcts.reform.rmi.model;

public class CmcDefence {

	private String submissionDate;
	private String mediationPaid;
	private String status;
	/**
	 * @return the submissionDate
	 */
	public String getSubmissionDate() {
		return submissionDate;
	}
	/**
	 * @param submissionDate the submissionDate to set
	 */
	public void setSubmissionDate(String submissionDate) {
		this.submissionDate = submissionDate;
	}
	/**
	 * @return the mediationPaid
	 */
	public String getMediationPaid() {
		return mediationPaid;
	}
	/**
	 * @param mediationPaid the mediationPaid to set
	 */
	public void setMediationPaid(String mediationPaid) {
		this.mediationPaid = mediationPaid;
	}
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CmcDefence [submissionDate=" + submissionDate + ", mediationPaid=" + mediationPaid + ", status="
				+ status + ", getSubmissionDate()=" + getSubmissionDate() + ", getMediationPaid()=" + getMediationPaid()
				+ ", getStatus()=" + getStatus() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	public CmcDefence() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
