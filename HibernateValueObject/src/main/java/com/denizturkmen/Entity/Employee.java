package com.denizturkmen.Entity;

import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

import com.denizturkmen.Model.Adres;

@Entity
@Table(name = "Employee_Table")
@DynamicUpdate
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Employee_id")
	private Integer employeeId;

	@Column(name = "Employee_name", length = 100, nullable = false)
	private String EmployeeName;

	@Column(name = "Email", unique = false)
	private String Email;

	@Column(name = "Date_of_Joining")
	private Date doj;

	@Column(name = "Salary")
	private Double Salary;

	// modeli buraya ilişkilendirmek için
	
	@Embedded
	//Columns isimleri değiştirmek için
	@AttributeOverrides(value = {
			@AttributeOverride(column = @Column(name = "Home_Street_name",length = 50),name = "streets"),
			@AttributeOverride(column = @Column(name = "Home_City_Name"),name = "citys"),
			@AttributeOverride(column = @Column(name = "Home_State_Name"),name = "states"),
			@AttributeOverride(column = @Column(name = "Home_Pin_Code"),name = "pincodes")
	})
	private Adres HomeAdress;
	
	
	@Embedded
	@AttributeOverrides(value = {
			@AttributeOverride(column = @Column(name = "Offical_Street_name",length = 50),name = "street"),
			@AttributeOverride(column = @Column(name = "Offical_City_Name"),name = "city"),
			@AttributeOverride(column = @Column(name = "Offical_State_Name"),name = "state"),
			@AttributeOverride(column = @Column(name = "Offical_Pin_Code"),name = "pincode")
	})
	private Adres OfficeAdress;


	public Integer getEmployeeId() {
		return employeeId;
	}


	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}


	public String getEmployeeName() {
		return EmployeeName;
	}


	public void setEmployeeName(String employeeName) {
		EmployeeName = employeeName;
	}


	public String getEmail() {
		return Email;
	}


	public void setEmail(String email) {
		Email = email;
	}


	public Date getDoj() {
		return doj;
	}


	public void setDoj(Date doj) {
		this.doj = doj;
	}


	public Double getSalary() {
		return Salary;
	}


	public void setSalary(Double salary) {
		Salary = salary;
	}


	public Adres getHomeAdress() {
		return HomeAdress;
	}


	public void setHomeAdress(Adres homeAdress) {
		HomeAdress = homeAdress;
	}


	public Adres getOfficeAdress() {
		return OfficeAdress;
	}


	public void setOfficeAdress(Adres officeAdress) {
		OfficeAdress = officeAdress;
	}


	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", EmployeeName=" + EmployeeName + ", Email=" + Email + ", doj="
				+ doj + ", Salary=" + Salary + ", HomeAdress=" + HomeAdress + ", OfficeAdress=" + OfficeAdress + "]";
	}


	
	//tek adresli alan
	
	/*
	 * public Integer getEmployeeId() { return employeeId; }
	 * 
	 * public void setEmployeeId(Integer employeeId) { this.employeeId = employeeId;
	 * }
	 * 
	 * public String getEmployeeName() { return EmployeeName; }
	 * 
	 * public void setEmployeeName(String employeeName) { EmployeeName =
	 * employeeName; }
	 * 
	 * public String getEmail() { return Email; }
	 * 
	 * public void setEmail(String email) { Email = email; }
	 * 
	 * public Date getDoj() { return doj; }
	 * 
	 * public void setDoj(Date doj) { this.doj = doj; }
	 * 
	 * public Double getSalary() { return Salary; }
	 * 
	 * public void setSalary(Double salary) { Salary = salary; }
	 * 
	 * public Adres getAdress() { return Adress; }
	 * 
	 * public void setAdress(Adres adress) { Adress = adress; }
	 * 
	 * @Override public String toString() { return "Employee [employeeId=" +
	 * employeeId + ", EmployeeName=" + EmployeeName + ", Email=" + Email + ", doj="
	 * + doj + ", Salary=" + Salary + ", Adress=" + Adress + "]"; }
	 */

	
	
	
	
}
