package com.icegate.IceGate.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_master")
public class UserEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private Long user_id;

	@Column(name = "login_id")
	private String login_id;

	@Column(name = "password")
	private String password;

	@Column(name = "first_name")
	private String first_name;

	@Column(name = "last_name")
	private String last_name;

	@Column(name = "company")
	private String company;

	@Column(name = "contact")
	private String contact;

	@Column(name = "created_date")
	private LocalDateTime created_date;

	@Column(name = "updated_date")
	private LocalDateTime updated_date;

//	@OneToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "country")
//    private CountryEntity country;

//	@OneToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "city")
//    private CityEntity city;

	public Long getId() {
		return user_id;
	}

	public void setId(Long id) {
		this.user_id = id;
	}

	public String getLoginId() {
		return login_id;
	}

	public void setLoginId(String loginId) {
		this.login_id = loginId;
	}

	public String getFirstName() {
		return first_name;
	}

	public void setFirstName(String firstName) {
		this.first_name = firstName;
	}

	public String getLastName() {
		return last_name;
	}

	public void setLastName(String lastName) {
		this.last_name = lastName;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public LocalDateTime getCreatedDate() {
		return created_date;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.created_date = createdDate;
	}

	public LocalDateTime getUpdatedDate() {
		return updated_date;
	}

	public void setUpdatedDate(LocalDateTime updatedDate) {
		this.updated_date = updatedDate;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
//	public CountryEntity getCountry() {
//		return country;
//	}
//
//	public void setCountry(CountryEntity country) {
//		this.country = country;
//	}
//
//	public CityEntity getCity() {
//		return city;
//	}
//
//	public void setCity(CityEntity city) {
//		this.city = city;
//	}

}
