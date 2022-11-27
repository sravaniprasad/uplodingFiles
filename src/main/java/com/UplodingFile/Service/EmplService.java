package com.UplodingFile.Service;

import java.util.List;
import java.util.Optional;

import com.UplodingFile.Entity.Employee;

public interface EmplService {

	List<Employee> searchEmployee(String query);
	
	Employee saveEmployee(Employee employee);

	Employee getEmployeeById(Integer InvoiceNo);
	Employee UpdateEmployee(Employee employee, Integer InvoiceNo);
	void deleteEmployee(int InvoiceNo);

	Employee getEmployeeByIdName(Employee employee, int invoiceNo);

	Employee findById(int invoiceNo);

	}