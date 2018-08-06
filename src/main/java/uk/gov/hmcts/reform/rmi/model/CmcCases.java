package uk.gov.hmcts.reform.rmi.model;

public class CmcCases {

	private String submissionDate;
	private double claimTotal;
	private double claimfee;
	private String status;
	
	
	public CmcCases() {
		super();
		// TODO Auto-generated constructor stub
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CmcCases [submissionDate=" + submissionDate + ", claimTotal=" + claimTotal + ", claimfee=" + claimfee
				+ ", status=" + status + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	public CmcCases(String submissionDate, double claimTotal, double claimfee, String status) {
		super();
		this.submissionDate = submissionDate;
		this.claimTotal = claimTotal;
		this.claimfee = claimfee;
		this.status = status;
	}
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
	 * @return the claimTotal
	 */
	public double getClaimTotal() {
		return claimTotal;
	}
	/**
	 * @param claimTotal the claimTotal to set
	 */
	public void setClaimTotal(double claimTotal) {
		this.claimTotal = claimTotal;
	}
	/**
	 * @return the claimfee
	 */
	public double getClaimfee() {
		return claimfee;
	}
	/**
	 * @param claimfee the claimfee to set
	 */
	public void setClaimfee(double claimfee) {
		this.claimfee = claimfee;
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
	
}
