package com.UplodingFile.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Student {

	
	
	//BatchNo,BatchName,StudentName,Area,Percentage,Grade
	
	@Id 
	@GeneratedValue
	private int id;
	private String batchName;
	private String studentName;
	private String area;
	private String percentage;
	private String grade;
	
	public String getBatchName() {
		return batchName;
	}
	public void setBatchName(String batchName) {
		this.batchName = batchName;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getPercentage() {
		return percentage;
	}
	public void setPercentage(String percentage) {
		this.percentage = percentage;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	
	
	public Student(int id, String batchName, String studentName, String area, String percentage, String grade) {
		super();
		this.id = id;
		this.batchName = batchName;
		this.studentName = studentName;
		this.area = area;
		this.percentage = percentage;
		this.grade = grade;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Student [batchNo=" + id + ", batchName=" + batchName + ", studentName=" + studentName + ", area="
				+ area + ", percentage=" + percentage + ", grade=" + grade + "]";
	}
	
	
}
