package com.icegate.IceGate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "city")
public class CityEntity {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "city_id")
    private Long city_id;
	
	@Column(name = "city_name")
    private String city_name;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "country")
    private CountryEntity country;

	public Long getCityId() {
		return city_id;
	}

	public void setCityId(Long cityId) {
		this.city_id = cityId;
	}

	public String getCityName() {
		return city_name;
	}

	public void setCityName(String cityName) {
		this.city_name = cityName;
	}

	public CountryEntity getCountry() {
		return country;
	}

	public void setCountry(CountryEntity country) {
		this.country = country;
	}
	

	
	
	
}
