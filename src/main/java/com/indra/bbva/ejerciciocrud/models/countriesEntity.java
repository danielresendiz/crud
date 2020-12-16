package com.indra.bbva.ejerciciocrud.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name="COUNTRIES")
public class countriesEntity {
	
	@Id 
	@Column(name="COUNTRY_ID")
	private String countryID;
	@Column(name="COUNTRY_NAME")
	private String countryName;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "REGION_ID",referencedColumnName = "REGION_ID")
	//@JsonBackReference
	private regionsEntity regionID;
	
	public countriesEntity() {
		
	}

	public countriesEntity(String countryID, String countryName, regionsEntity regionID) {
		super();
		this.countryID = countryID;
		this.countryName = countryName;
		this.regionID = regionID;
	}

	public String getCountryID() {
		return countryID;
	}

	public void setCountryID(String countryID) {
		this.countryID = countryID;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public regionsEntity getRegionID() {
		return regionID;
	}

	public void setRegionID(regionsEntity regionID) {
		this.regionID = regionID;
	}

	

}
