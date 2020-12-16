package com.indra.bbva.ejerciciocrud.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="REGIONS")
public class regionsEntity {
	
	@Id //@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="REGION_ID")
	private Integer regionID;

	@Column(name="REGION_NAME" )
	private String regionName;
	
	//@OneToOne(cascade=CascadeType.ALL,mappedBy ="regionID")
	//private List<countriesEntity> country;
	
	
    public regionsEntity() {
		
	}
	public regionsEntity(Integer regionID, String regionName) {
		super();
		this.regionID = regionID;
		this.regionName = regionName;
	}
	public Integer getRegionID() {
		return regionID;
	}
	public void setRegionID(Integer regionID) {
		this.regionID = regionID;
	}
	public String getRegionName() {
		return regionName;
	}
	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}
	
	
	
	
	
	
}
