package com.indra.bbva.ejerciciocrud.models;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.lang.Nullable;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name="DEPARTMENTS")
public class departmentsEntity {

	@Id //@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="DEPARTMENT_ID")
	private Integer departmentID;
	@Column(name="DEPARTMENT_NAME")
	private String departmentName;
	@Column(name="MANAGER_ID")
	private Integer managerID;
	//@Column(name="LOCATION_ID")

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "LOCATION_ID",referencedColumnName = "LOCATION_ID")
	private locationsEntity locationID;
	
	public departmentsEntity() {
		
	}

	public departmentsEntity(Integer departmentID, String departmentName, Integer managerID, locationsEntity locationID) {
		super();
		this.departmentID = departmentID;
		this.departmentName = departmentName;
		this.managerID = managerID;
		this.locationID = locationID;
	}

	public Integer getDepartmentID() {
		return departmentID;
	}

	public void setDepartmentID(Integer departmentID) {
		this.departmentID = departmentID;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public Integer getManagerID() {
		return managerID;
	}

	public void setManagerID(Integer managerID) {
		this.managerID = managerID;
	}

	public locationsEntity getLocationID() {
		return locationID;
	}

	public void setLocationID(locationsEntity locationID) {
		this.locationID = locationID;
	}
	
}
