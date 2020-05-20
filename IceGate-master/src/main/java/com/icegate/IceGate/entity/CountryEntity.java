package com.icegate.IceGate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "country")
public class CountryEntity {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "country_id")
    private Long country_id;
	
	@Column(name = "country_name")
    private String country_name;

	public Long getCountryId() {
		return country_id;
	}

	public void setCountryId(Long countryId) {
		this.country_id = countryId;
	}

	public String getCountryName() {
		return country_name;
	}

	public void setCountryName(String countryName) {
		this.country_name = countryName;
	}

	
	
	
}
