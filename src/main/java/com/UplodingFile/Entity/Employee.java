package com.UplodingFile.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Builder;

@Entity
@Builder
public class Employee {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)

	private Integer InvoiceNo;
	
	private String empname;
	
	private String empaddress;
	
	private String emprole;
	
	

	public Integer getInvoiceNo() {
		return InvoiceNo;
	}
 
	public void setInvoiceNo(Integer invoiceNo) {
		InvoiceNo = invoiceNo;
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
		this.InvoiceNo = invoiceNo;
		this.empname = empname;
		this.empaddress = empaddress;
		this.emprole = emprole;
	}

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	
	
	

}
