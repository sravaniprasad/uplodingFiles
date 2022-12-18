package com.UplodingFile;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import com.UplodingFile.Controller.EmployeeController;

@SpringBootTest
public class EmployeeTest {
	@Autowired
	private EmployeeController empController;
	
	
	 
	
	@Test
	void contextLoads() {
         assertThat(empController).isNotNull();
	}
	
}
