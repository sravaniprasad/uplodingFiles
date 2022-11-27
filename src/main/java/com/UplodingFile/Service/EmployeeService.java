package com.UplodingFile.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.UplodingFile.Entity.Employee;
import com.UplodingFile.Exception.ResourceNotFoundException;
import com.UplodingFile.Exception.UserNotFoundException;
import com.UplodingFile.Helper.ExclHelper;
import com.UplodingFile.Repository.EmployeeRepo;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepo empRepo;
	
	public void save(MultipartFile file) {
		
		try {
			
			List<Employee> emp = ExclHelper.ConvertExcelToListOfEmployee(file.getInputStream());
			this.empRepo.saveAll(emp);
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public List<Employee> getAllEmployees(){
		List<Employee>emplist=empRepo.findAll();
		if(emplist.isEmpty())
			throw new UserNotFoundException("List is empty, please upload the file");
		return emplist;
		//return this.empRepo.findAll();
	}
	}
	

