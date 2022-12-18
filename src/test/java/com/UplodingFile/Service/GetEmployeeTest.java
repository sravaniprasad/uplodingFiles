package com.UplodingFile.Service;
import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import com.UplodingFile.Entity.Employee;
import com.UplodingFile.Exception.UserNotFoundException;
import com.UplodingFile.Repository.EmployeeRepo;
import com.UplodingFile.ServiceImplementation.EmployeeServiceImpl;
@Ignore
@SpringBootTest
public class GetEmployeeTest {
	@Autowired
	private EmployeeServiceImpl emplService;
	
	@MockBean
	private EmployeeRepo empRepo; 
	
	
	
	@Test
	void contextLoads() {}
	@Test
	public void getAllEmployeesTest() {
		when(empRepo.findAll()).thenReturn(Stream.of(new Employee(41,"srav","md","mumbai"),new Employee(43,"lilla","md","pune")).collect(Collectors.toList()));
	assertEquals(2,emplService.getAllEmployees().size());
	assertFalse(1==emplService.getAllEmployees().size());
	}
	@Test
	public void saveEmployeeTest() {
		Employee e=new Employee(23,"kappa","india","md");
		when(empRepo.save(e)).thenReturn(e);
        assertEquals(e,emplService.saveEmployee(e));	
	}
	
	@Test
	@Ignore
	public void assertThrowsWithNoMessage() {
		
		//EmployeeServiceImpl e=new EmployeeServiceImpl(empRepo);
		
		Employee emp=new Employee(23,"kappa","india","md");
		
		emplService.saveEmployee(emp);
		
		UserNotFoundException userNotFound=assertThrows(UserNotFoundException.class,()->emplService.getEmployeeById(23));
		//assertEquals("Employee not found", userNotFound.getMessage());
		// assertEquals(e,emplService.);	
		
		assertThrows(UserNotFoundException.class,
				() ->emplService.getEmployeeById(2),
				"Different exception thrown!"+userNotFound.getMessage());

			
	}
}
