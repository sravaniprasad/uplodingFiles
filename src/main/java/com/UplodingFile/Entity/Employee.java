package com.UplodingFile.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Employee {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Integer empId;
	
	private String empname;
	
	private String empaddress;
	
	private String emprole;
	
	

	public Integer getInvoiceNo() {
		return empId;
	}
 
	public void setInvoiceNo(Integer invoiceNo) {
		empId = invoiceNo;
	}

	public String getEmpname() {
		return empname;
	}

	public void setEmpname(String empname) {
		this.empname = empname;
	}

	public String getEmpaddress() {
		return empaddress;
	}

	public void setEmpaddress(String empaddress) {
		this.empaddress = empaddress;
	}

	public String getEmprole() {
		return emprole;
	}

	public void setEmprole(String emprole) {
		this.emprole = emprole;
	}

	public Employee(Integer invoiceNo, String empname, String empaddress, String emprole) {
		super();
		this.empId = invoiceNo;
		this.empname = empname;
		this.empaddress = empaddress;
		this.emprole = emprole;
	}

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	
	
	

}
