package uk.gov.hmcts.reform.rmi.model;

public class ScssDTO {

	
	String typeId;
	String caseReference;
	String sms;
	String email;
	String region;
	String benefitType;
	String benefitCode;
	String hearingType;
	String venuName;
	/**
	 * @return the typeId
	 */
	public String getTypeId() {
		return typeId;
	}
	/**
	 * @param typeId the typeId to set
	 */
	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}
	/**
	 * @return the caseReference
	 */
	public String getCaseReference() {
		return caseReference;
	}
	/**
	 * @param caseReference the caseReference to set
	 */
	public void setCaseReference(String caseReference) {
		this.caseReference = caseReference;
	}
	/**
	 * @return the sms
	 */
	public String getSms() {
		return sms;
	}
	/**
	 * @param sms the sms to set
	 */
	public void setSms(String sms) {
		this.sms = sms;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the region
	 */
	public String getRegion() {
		return region;
	}
	/**
	 * @param region the region to set
	 */
	public void setRegion(String region) {
		this.region = region;
	}
	/**
	 * @return the benefitType
	 */
	public String getBenefitType() {
		return benefitType;
	}
	/**
	 * @param benefitType the benefitType to set
	 */
	public void setBenefitType(String benefitType) {
		this.benefitType = benefitType;
	}
	/**
	 * @return the benefitCode
	 */
	public String getBenefitCode() {
		return benefitCode;
	}
	/**
	 * @param benefitCode the benefitCode to set
	 */
	public void setBenefitCode(String benefitCode) {
		this.benefitCode = benefitCode;
	}
	/**
	 * @return the hearingType
	 */
	public String getHearingType() {
		return hearingType;
	}
	/**
	 * @param hearingType the hearingType to set
	 */
	public void setHearingType(String hearingType) {
		this.hearingType = hearingType;
	}
	/**
	 * @return the venuName
	 */
	public String getVenuName() {
		return venuName;
	}
	/**
	 * @param venuName the venuName to set
	 */
	public void setVenuName(String venuName) {
		this.venuName = venuName;
	}
	
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ScssDTO [typeId=" + typeId + ", caseReference=" + caseReference + ", sms=" + sms + ", email=" + email
				+ ", region=" + region + ", benefitType=" + benefitType + ", benefitCode=" + benefitCode
				+ ", hearingType=" + hearingType + ", venuName=" + venuName + ", getTypeId()=" + getTypeId()
				+ ", getCaseReference()=" + getCaseReference() + ", getSms()=" + getSms() + ", getEmail()=" + getEmail()
				+ ", getRegion()=" + getRegion() + ", getBenefitType()=" + getBenefitType() + ", getBenefitCode()="
				+ getBenefitCode() + ", getHearingType()=" + getHearingType() + ", getVenuName()=" + getVenuName()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	
	
	
	public ScssDTO(String typeId, String caseReference, String sms, String email, String region, String benefitType,
			String benefitCode, String hearingType, String venuName) {
		super();
		this.typeId = typeId;
		this.caseReference = caseReference;
		this.sms = sms;
		this.email = email;
		this.region = region;
		this.benefitType = benefitType;
		this.benefitCode = benefitCode;
		this.hearingType = hearingType;
		this.venuName = venuName;
	}
	
	
	
	
}
