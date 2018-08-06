package uk.gov.hmcts.reform.rmi.model;

public class ProbateDTO {

	String matricDate;
	String matric;
	double request;
	/**
	 * @return the matricDate
	 */
	public String getMatricDate() {
		return matricDate;
	}
	/**
	 * @param matricDate the matricDate to set
	 */
	public void setMatricDate(String matricDate) {
		this.matricDate = matricDate;
	}
	/**
	 * @return the matric
	 */
	public String getMatric() {
		return matric;
	}
	/**
	 * @param matric the matric to set
	 */
	public void setMatric(String matric) {
		this.matric = matric;
	}
	/**
	 * @return the request
	 */
	public double getRequest() {
		return request;
	}
	/**
	 * @param request the request to set
	 */
	public void setRequest(double request) {
		this.request = request;
	}
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ProbateDTO [matricDate=" + matricDate + ", matric=" + matric + ", request=" + request
				+ ", getMatricDate()=" + getMatricDate() + ", getMatric()=" + getMatric() + ", getRequest()="
				+ getRequest() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	
	
	public ProbateDTO(String matricDate, String matric, double request) {
		super();
		this.matricDate = matricDate;
		this.matric = matric;
		this.request = request;
	}
	
	
	
}
