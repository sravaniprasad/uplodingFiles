package com.UplodingFile.Service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.UplodingFile.Entity.Employee;
import com.UplodingFile.Exception.UserNotFoundException;
import com.UplodingFile.Repository.EmployeeRepo;
import com.UplodingFile.ServiceImplementation.EmployeeServiceImpl;




class GetEmpById {

	@InjectMocks
	EmployeeServiceImpl empServImpl;
	
	@Mock
	EmployeeRepo empRepo;
	
	
	@BeforeEach
	void setUp() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testGetEmployee() {
		Employee e=new Employee(23,"kappa","india","md");
		when(empRepo.save(e)).thenReturn(e);
		
	}
	
	@Test
public void getEmp() {
	when(empRepo.findById(anyInt())).thenReturn(null);
	
	assertThrows(UserNotFoundException.class,()-> empServImpl.getEmployeeById(23));
}
}
