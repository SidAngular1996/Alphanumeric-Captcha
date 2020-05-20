package com.icegate.IceGate.request;

import java.time.LocalDateTime;

public class UserRequest {

	    private Long userId;
		
	    private String loginId;
		
	    private String firstName;
		
	    private String lastName;
		
	    private Short company;
		
	    private Short contact;
		
	    private String first_name;
		
	    private String last_name;
		
	    private LocalDateTime createdDate;
		
	    private LocalDateTime updatedDate;
		
	    private Long country;
	    private Long city;

		public Long getUserId() {
			return userId;
		}

		public void setUserId(Long userId) {
			this.userId = userId;
		}

		public String getLoginId() {
			return loginId;
		}

		public void setLoginId(String loginId) {
			this.loginId = loginId;
		}

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public Short getCompany() {
			return company;
		}

		public void setCompany(Short company) {
			this.company = company;
		}

		public Short getContact() {
			return contact;
		}

		public void setContact(Short contact) {
			this.contact = contact;
		}

		public String getFirst_name() {
			return first_name;
		}

		public void setFirst_name(String first_name) {
			this.first_name = first_name;
		}

		public String getLast_name() {
			return last_name;
		}

		public void setLast_name(String last_name) {
			this.last_name = last_name;
		}

		public LocalDateTime getCreatedDate() {
			return createdDate;
		}

		public void setCreatedDate(LocalDateTime createdDate) {
			this.createdDate = createdDate;
		}

		public LocalDateTime getUpdatedDate() {
			return updatedDate;
		}

		public void setUpdatedDate(LocalDateTime updatedDate) {
			this.updatedDate = updatedDate;
		}

		public Long getCountry() {
			return country;
		}

		public void setCountry(Long country) {
			this.country = country;
		}

		public Long getCity() {
			return city;
		}

		public void setCity(Long city) {
			this.city = city;
		}


	
	    
}
