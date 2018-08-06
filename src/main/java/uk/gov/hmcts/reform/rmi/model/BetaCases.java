package uk.gov.hmcts.reform.rmi.model;

public class BetaCases{
	
	 
		private String priority;
		private String state;
		private String shortDescription;
		private String description;
		
		private String category;
		private String assignmentGroup;
		private String numbers;

		private String service;
		private String serviceOffering;

		private String created;
		private String updated;
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
		 * @return the numbers
		 */
		public String getNumbers() {
			return numbers;
		}
		/**
		 * @param numbers the numbers to set
		 */
		public void setNumbers(String numbers) {
			this.numbers = numbers;
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
		 * @return the created
		 */
		public String getCreated() {
			return created;
		}
		/**
		 * @param created the created to set
		 */
		public void setCreated(String created) {
			this.created = created;
		}
		/**
		 * @return the updated
		 */
		public String getUpdated() {
			return updated;
		}
		/**
		 * @param updated the updated to set
		 */
		public void setUpdated(String updated) {
			this.updated = updated;
		}
		public BetaCases() {
			super();
			// TODO Auto-generated constructor stub
		}
		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return "BetaCases [priority=" + priority + ", state=" + state + ", shortDescription=" + shortDescription
					+ ", description=" + description + ", category=" + category + ", assignmentGroup=" + assignmentGroup
					+ ", numbers=" + numbers + ", service=" + service + ", serviceOffering=" + serviceOffering
					+ ", created=" + created + ", updated=" + updated + ", getPriority()=" + getPriority()
					+ ", getState()=" + getState() + ", getShortDescription()=" + getShortDescription()
					+ ", getDescription()=" + getDescription() + ", getCategory()=" + getCategory()
					+ ", getAssignmentGroup()=" + getAssignmentGroup() + ", getNumbers()=" + getNumbers()
					+ ", getService()=" + getService() + ", getServiceOffering()=" + getServiceOffering()
					+ ", getCreated()=" + getCreated() + ", getUpdated()=" + getUpdated() + ", getClass()=" + getClass()
					+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
		}
		
		
		
}
