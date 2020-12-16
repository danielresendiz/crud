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
@Table(name="EMPLOYEES")
public class employeesEntity {
	
	@Id //@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="EMPLOYEE_ID")
	private Integer employeeID;
	@Column(name="FIRST_NAME")
	private String firstName;
	@Column(name="LAST_NAME")
	private String lastName;
	@Column(name="EMAIL")
	private String email;
	@Column(name="PHONE_NUMBER")
	private String phoneNumbre;
	@Column(name="HIRE_DATE")
	private Date hireDate;
	@Column(name="JOB_ID")
	//@ManyToOne(fetch = FetchType.LAZY, optional = false)
	//@JoinColumn(name = "JOB_ID",referencedColumnName = "JOB_ID")
	private String jobID;
	@Column(name="SALARY")
	private Float salary;
	@Column(name="COMMISSION_PCT")
	private Float commissionPCT;
	@Column(name="MANAGER_ID")
	private Integer managerID;
	
	//@ManyToOne(fetch = FetchType.LAZY, optional = false)
	//@JoinColumn(name = "DEPARTMENT_ID",referencedColumnName = "DEPARTMENT_ID")
	@Column(name="DEPARTMENT_ID")
	private Integer departmentID;
	
	
	/* desde posman en formato json
	 * {
    
			"employeeID": 99,
			"firstName": "daniel0",
			"lastName": "rodriguez",
			"email": "rraggsjsa",
			"phoneNumbre": "515.123.4567",
			"hireDate": "2008-07-24T00:00:00.000+00:000",
			"jobID": { 
							"jobID":"AD_PRES"
					 },
			"salary": 24000.0,
			"commissionPCT": 0.3,
			"managerID": 200,
			"departmentID": { 
							"departmentID":"10"
					 }
		}
	 */
	public employeesEntity() {
		
	}
	
	public employeesEntity(Integer employeeID, String firstName, String lastName, String email, String phoneNumbre,
			Date hireDate, String jobID, Float salary, Float commissionPCT, Integer managerID, Integer departmentID) {
		super();
		this.employeeID = employeeID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumbre = phoneNumbre;
		this.hireDate = hireDate;
		this.jobID = jobID;
		this.salary = salary;
		this.commissionPCT = commissionPCT;
		this.managerID = managerID;
		this.departmentID = departmentID;
	}
	
	public Integer getEmployeID() {
		return employeeID;
	}
	public void setEmployeID(Integer employeID) {
		this.employeeID = employeID;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumbre() {
		return phoneNumbre;
	}
	public void setPhoneNumbre(String phoneNumbre) {
		this.phoneNumbre = phoneNumbre;
	}
	public Date getHireDate() {
		return hireDate;
	}
	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}
	public String getJobID() {
		return jobID;
	}
	public void setJobID(String jobID) {
		this.jobID = jobID;
	}
	public Float getSalary() {
		return salary;
	}
	public void setSalary(Float salary) {
		this.salary = salary;
	}
	public Float getCommissionPCT() {
		return commissionPCT;
	}
	public void setCommissionPCT(Float commissionPCT) {
		this.commissionPCT = commissionPCT;
	}
	public Integer getManagerID() {
		return managerID;
	}
	public void setManagerID(Integer managerID) {
		this.managerID = managerID;
	}
	public Integer getDepartmentID() {
		return departmentID;
	}
	public void setDepartmentID(Integer departmentID) {
		this.departmentID = departmentID;
	}
	
}