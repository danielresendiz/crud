package com.indra.bbva.ejerciciocrud.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name="LOCATIONS")
public class locationsEntity {
	
	@Id 
	//@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="LOCATIONS_SEQ")
    //@SequenceGenerator(name="LOCATIONS_SEQ", sequenceName = "LOCATIONS_SEQ", allocationSize=1)
	@Column(name="LOCATION_ID")
	private Integer locationID;
	@Column(name="STREET_ADDRESS")
	private String streetAddres;
	@Column(name="POSTAL_CODE")
	private String postalCode;
	@Column(name="CITY")
	private String city;
	@Column(name="STATE_PROVINCE")
	private String stateProvince;
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "COUNTRY_ID",referencedColumnName = "COUNTRY_ID")
	private countriesEntity countryID;
	
	

	//@ManyToOne @JoinColumn(name="COUNTRY_ID")
	//private countriesEntity countryID;
	
	public locationsEntity() {
		
	}
	public locationsEntity(Integer locationID, String streetAddres, String postalCode, String city, String stateProvince,
			countriesEntity countryID) {
		super();
		this.locationID = locationID;
		this.streetAddres = streetAddres;
		this.postalCode = postalCode;
		this.city = city;
		this.stateProvince = stateProvince;
		this.countryID = countryID;
	}
	public Integer getLocationID() {
		return locationID;
	}
	public void setLocationID(Integer locationID) {
		this.locationID = locationID;
	}
	public String getStreetAddres() {
		return streetAddres;
	}
	public void setStreetAddres(String streetAddres) {
		this.streetAddres = streetAddres;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getStateProvince() {
		return stateProvince;
	}
	public void setStateProvince(String stateProvince) {
		this.stateProvince = stateProvince;
	}
	public countriesEntity getCountryID() {
		return countryID;
	}
	public void setCountryID(countriesEntity countryID) {
		this.countryID = countryID;
	}
	
	
}
