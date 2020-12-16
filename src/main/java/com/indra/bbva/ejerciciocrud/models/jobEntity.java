package com.indra.bbva.ejerciciocrud.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="JOBS")
public class jobEntity {
	
	@Id //@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="JOB_ID")
	private String jobID;
	@Column(name="JOB_TITLE")
	private String jobTitle;
	@Column(name="MIN_SALARY")
	private Integer minSalary;
	@Column(name="MAX_SALARY")
	private Integer maxSalary;
	
	
	public jobEntity() {
		
	}


	public jobEntity(String jobID, String jobTitle, Integer minSalary, Integer maxSalary) {
		super();
		this.jobID = jobID;
		this.jobTitle = jobTitle;
		this.minSalary = minSalary;
		this.maxSalary = maxSalary;
	}


	public String getJobID() {
		return jobID;
	}


	public void setJobID(String jobID) {
		this.jobID = jobID;
	}


	public String getJobTitle() {
		return jobTitle;
	}


	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}


	public Integer getMinSalary() {
		return minSalary;
	}


	public void setMinSalary(Integer minSalary) {
		this.minSalary = minSalary;
	}


	public Integer getMaxSalary() {
		return maxSalary;
	}


	public void setMaxSalary(Integer maxSalary) {
		this.maxSalary = maxSalary;
	}
	
	
}
