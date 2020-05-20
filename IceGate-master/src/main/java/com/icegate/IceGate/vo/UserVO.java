package com.icegate.IceGate.vo;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.icegate.IceGate.entity.UserEntity;

@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id", scope = UserVO.class)
public class UserVO {

	private Long userId;
	private String loginId;
	private String company;
	private String contact;
	private String first_name;
	private String last_name;
	private LocalDateTime created_date;
	private LocalDateTime updated_date;
	private String password;
	private String captchaId;
	private String userEnteredCaptchaCode;
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private String country;
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	
	
	
	private String city;

	public String getCaptchaId() {
		return captchaId;
	}

	public void setCaptchaId(String captchaId) {
		this.captchaId = captchaId;
	}

	public String getUserEnteredCaptchaCode() {
		return userEnteredCaptchaCode;
	}

	public void setUserEnteredCaptchaCode(String userEnteredCaptchaCode) {
		this.userEnteredCaptchaCode = userEnteredCaptchaCode;
	}

	private String captchaResponse;

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

	public String getCompany() {
		return company;
	}

	public void setCompany(String string) {
		this.company = string;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
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

	public LocalDateTime getCreated_date() {
		return created_date;
	}

	public void setCreated_date(LocalDateTime created_date) {
		this.created_date = created_date;
	}

	public LocalDateTime getUpdated_date() {
		return updated_date;
	}

	public void setUpdated_date(LocalDateTime updated_date) {
		this.updated_date = updated_date;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCaptchaResponse() {
		return captchaResponse;
	}

	public void setCaptchaResponse(String captchaResponse) {
		this.captchaResponse = captchaResponse;
	}

	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserVO() {

	}

	public UserVO(UserEntity userEntity) {
		this.setUserId(userEntity.getId());
		this.setFirst_name(userEntity.getFirstName());
		this.setCompany(userEntity.getCompany());
		this.setContact(userEntity.getContact());
//			this.setCountry(userEntity.getCountry().getCountryName());
		this.setLast_name(userEntity.getLastName());
		this.setLoginId(userEntity.getLoginId());
//			this.setCity(userEntity.getCity().getCityName());
		this.setUpdated_date(userEntity.getUpdatedDate());
		this.setCreated_date(userEntity.getCreatedDate());
	}

}
