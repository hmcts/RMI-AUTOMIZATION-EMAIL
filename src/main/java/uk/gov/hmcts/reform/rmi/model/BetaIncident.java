package uk.gov.hmcts.reform.rmi.model;

public class BetaIncident{
	
	 
		private String priority;
		private String incidentState;
		private String state;
		private String shortDescription;
		private String category;
		private String subCategory;
		private String description;
		private String assignmentGroup;
		private String thirdPartysupportReference;
		private boolean madeSla;
		private String serviceOffering;
		private String servicePortfolio;
		private String service;
		private String contactType;
		private String createdDateTime;
		private String updatedDateTime;
		private String resolveTime;
		private String resolved;
		
		
		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return "betaIncident [priority=" + priority + ", incidentState=" + incidentState + ", state=" + state
					+ ", shortDescription=" + shortDescription + ", category=" + category + ", subCategory="
					+ subCategory + ", description=" + description + ", assignmentGroup=" + assignmentGroup
					+ ", thirdPartysupportReference=" + thirdPartysupportReference + ", madeSla=" + madeSla
					+ ", serviceOffering=" + serviceOffering + ", servicePortfolio=" + servicePortfolio + ", service="
					+ service + ", contactType=" + contactType + ", createdDateTime=" + createdDateTime
					+ ", updatedDateTime=" + updatedDateTime + ", resolveTime=" + resolveTime + ", resolved="
					+ resolved + ", getPriority()=" + getPriority() + ", getIncidentState()=" + getIncidentState()
					+ ", getState()=" + getState() + ", getShortDescription()=" + getShortDescription()
					+ ", getCategory()=" + getCategory() + ", getSubCategory()=" + getSubCategory()
					+ ", getDescription()=" + getDescription() + ", getAssignmentGroup()=" + getAssignmentGroup()
					+ ", getThirdPartysupportReference()=" + getThirdPartysupportReference() + ", isMadeSla()="
					+ isMadeSla() + ", getServiceOffering()=" + getServiceOffering() + ", getServicePortfolio()="
					+ getServicePortfolio() + ", getService()=" + getService() + ", getContactType()="
					+ getContactType() + ", getCreatedDateTime()=" + getCreatedDateTime() + ", getUpdatedDateTime()="
					+ getUpdatedDateTime() + ", getResolveDateTime()=" + getResolveTime() + ", getResolved()="
					+ getResolved() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
					+ super.toString() + "]";
		}

		/**
		 * @return the priority
		 */
		public String getPriority() {
			return priority;
		}

		/**
		 * @param priority the priority to set
		 */
		public void setPriority(String priority) {
			this.priority = priority;
		}

		/**
		 * @return the incidentState
		 */
		public String getIncidentState() {
			return incidentState;
		}

		/**
		 * @param incidentState the incidentState to set
		 */
		public void setIncidentState(String incidentState) {
			this.incidentState = incidentState;
		}

		/**
		 * @return the state
		 */
		public String getState() {
			return state;
		}

		/**
		 * @param state the state to set
		 */
		public void setState(String state) {
			this.state = state;
		}

		/**
		 * @return the shortDescription
		 */
		public String getShortDescription() {
			return shortDescription;
		}

		/**
		 * @param shortDescription the shortDescription to set
		 */
		public void setShortDescription(String shortDescription) {
			this.shortDescription = shortDescription;
		}

		/**
		 * @return the category
		 */
		public String getCategory() {
			return category;
		}

		/**
		 * @param category the category to set
		 */
		public void setCategory(String category) {
			this.category = category;
		}

		/**
		 * @return the subCategory
		 */
		public String getSubCategory() {
			return subCategory;
		}

		/**
		 * @param subCategory the subCategory to set
		 */
		public void setSubCategory(String subCategory) {
			this.subCategory = subCategory;
		}

		/**
		 * @return the description
		 */
		public String getDescription() {
			return description;
		}

		/**
		 * @param description the description to set
		 */
		public void setDescription(String description) {
			this.description = description;
		}

		/**
		 * @return the assignmentGroup
		 */
		public String getAssignmentGroup() {
			return assignmentGroup;
		}

		/**
		 * @param assignmentGroup the assignmentGroup to set
		 */
		public void setAssignmentGroup(String assignmentGroup) {
			this.assignmentGroup = assignmentGroup;
		}

		/**
		 * @return the thirdPartysupportReference
		 */
		public String getThirdPartysupportReference() {
			return thirdPartysupportReference;
		}

		/**
		 * @param thirdPartysupportReference the thirdPartysupportReference to set
		 */
		public void setThirdPartysupportReference(String thirdPartysupportReference) {
			this.thirdPartysupportReference = thirdPartysupportReference;
		}

		/**
		 * @return the madeSla
		 */
		public boolean isMadeSla() {
			return madeSla;
		}

		/**
		 * @param madeSla the madeSla to set
		 */
		public void setMadeSla(boolean madeSla) {
			this.madeSla = madeSla;
		}

		/**
		 * @return the serviceOffering
		 */
		public String getServiceOffering() {
			return serviceOffering;
		}

		/**
		 * @param serviceOffering the serviceOffering to set
		 */
		public void setServiceOffering(String serviceOffering) {
			this.serviceOffering = serviceOffering;
		}

		/**
		 * @return the servicePortfolio
		 */
		public String getServicePortfolio() {
			return servicePortfolio;
		}

		/**
		 * @param servicePortfolio the servicePortfolio to set
		 */
		public void setServicePortfolio(String servicePortfolio) {
			this.servicePortfolio = servicePortfolio;
		}

		/**
		 * @return the service
		 */
		public String getService() {
			return service;
		}

		/**
		 * @param service the service to set
		 */
		public void setService(String service) {
			this.service = service;
		}

		/**
		 * @return the contactType
		 */
		public String getContactType() {
			return contactType;
		}

		/**
		 * @param contactType the contactType to set
		 */
		public void setContactType(String contactType) {
			this.contactType = contactType;
		}

		/**
		 * @return the createdDateTime
		 */
		public String getCreatedDateTime() {
			return createdDateTime;
		}

		/**
		 * @param createdDateTime the createdDateTime to set
		 */
		public void setCreatedDateTime(String createdDateTime) {
			this.createdDateTime = createdDateTime;
		}

		/**
		 * @return the updatedDateTime
		 */
		public String getUpdatedDateTime() {
			return updatedDateTime;
		}

		/**
		 * @param updatedDateTime the updatedDateTime to set
		 */
		public void setUpdatedDateTime(String updatedDateTime) {
			this.updatedDateTime = updatedDateTime;
		}

		/**
		 * @return the resolveDateTime
		 */
		public String getResolveTime() {
			return resolveTime;
		}

		/**
		 * @param resolveDateTime the resolveDateTime to set
		 */
		public void setResolveTime(String d) {
			this.resolveTime = d;
		}

		/**
		 * @return the resolved
		 */
		public String getResolved() {
			return resolved;
		}

		/**
		 * @param resolved the resolved to set
		 */
		public void setResolved(String resolved) {
			this.resolved = resolved;
		}

		public BetaIncident() {
			super();
			// TODO Auto-generated constructor stub
		}
		

}
