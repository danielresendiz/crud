package com.indra.bbva.ejerciciocrud.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name="JOB_HISTORY")
public class jobHistoryEntity {
	
	 //@GeneratedValue(strategy=GenerationType.AUTO)
	//@ManyToOne(fetch = FetchType.LAZY, optional = false)
	//@JoinColumn(name = "EMPLOYEE_ID",referencedColumnName = "EMPLOYEE_ID")
	@Column(name="EMPLOYEE_ID")
	private Integer employeeID;
	@Id
	@Column(name="START_DATE")
	private Date startDate;
	@Column(name="END_DATE")
	private Date endDate;

	//@ManyToOne(fetch = FetchType.LAZY, optional = false)
	//@JoinColumn(name = "JOB_ID",referencedColumnName = "JOB_ID")
	@Column(name="JOB_ID")
	private String jobID;

	//@ManyToOne(fetch = FetchType.LAZY, optional = false)
	//@JoinColumn(name = "DEPARTMENT_ID",referencedColumnName = "DEPARTMENT_ID")
	@Column(name="DEPARTMENT_ID")
	private Integer departmentID;
	public jobHistoryEntity() {
		
	}

	public jobHistoryEntity(Integer employeeID, Date startDate, Date endDate, String jobID, Integer departmentID) {
		super();
		this.employeeID = employeeID;
		this.startDate = startDate;
		this.endDate = endDate;
		this.jobID = jobID;
		this.departmentID = departmentID;
	}

	public Integer getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(Integer employeeID) {
		this.employeeID = employeeID;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getJobID() {
		return jobID;
	}

	public void setJobID(String jobID) {
		this.jobID = jobID;
	}

	public Integer getDepartmentID() {
		return departmentID;
	}

	public void setDepartmentID(Integer departmentID) {
		this.departmentID = departmentID;
	}
	
	
}
