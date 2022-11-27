package com.UplodingFile.Controller;



import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.UplodingFile.Entity.Employee;
import com.UplodingFile.Entity.Student;
import com.UplodingFile.Exception.EmptyInputException;
import com.UplodingFile.Exception.UserNotFoundException;
import com.UplodingFile.Helper.ExclHelper;
import com.UplodingFile.Repository.EmployeeRepo;
import com.UplodingFile.Service.EmplService;
import com.UplodingFile.Service.EmployeeService;
import com.UplodingFile.Service.StudentService;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin("*")
public class EmployeeController {
	
	@Autowired
	private EmployeeService empServ;
	
	
	@Autowired
	private StudentService studentService;

	
	@Autowired
	private EmplService emplservice;
	
	@Autowired
	private EmployeeRepo employeerepo;
	
	
	public EmployeeController(EmplService emplservice) {
		super();
		this.emplservice=emplservice;
	}
	
	
	//Create employee
	@PostMapping("/employee")
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){
		
		return new ResponseEntity<Employee>(emplservice.saveEmployee(employee),HttpStatus.CREATED);
	}
	
	
	
	
	//search employee by id
	@GetMapping("/employee/{InvoiceNo}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("InvoiceNo") Integer InvoiceNo){
		
		return new ResponseEntity<Employee>(emplservice.getEmployeeById(InvoiceNo), HttpStatus.OK);
	}
	
    //uploading file
	@PostMapping("/employee/upload")
	public ResponseEntity<?> upload(@RequestParam("file") MultipartFile file) throws UserNotFoundException{
		
		
		if(file.isEmpty()) {
			//return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Data not inserted!!! pease upload the file");
			throw new UserNotFoundException("file is not uploaded!! upload the file to see the records");
		}
		else if(ExclHelper.checkExcelFormat(file)) {
			
			this.empServ.save(file);
			
			return ResponseEntity.ok(Map.of("message","File is Uploaded. Records are inserted into DataBase"));
			
		}
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Data not inserted due to BADREQUEST");
		
		}
	

//get all employees	
	@GetMapping("/employee")
	public List<Employee> getAllEmployee(){
		return this.empServ.getAllEmployees();
	}

	
//update single id
	@PutMapping("/employee/{InvoiceNo}")
	public ResponseEntity<?> UpdateEmployee(@PathVariable ("InvoiceNo") int InvoiceNo,@RequestBody Employee employee){
		
	//	return new ResponseEntity<Employee>(emplservice.UpdateEmployee(employee,InvoiceNo), HttpStatus.OK);
		emplservice.UpdateEmployee(employee,InvoiceNo);
		//return new ResponseEntity<String>("Employee "+InvoiceNo +" was updated",HttpStatus.OK);
		return ResponseEntity.ok(Map.of("message","Details of "+InvoiceNo+ " are Updated"));
		
	}
	
	//Delete single id
	@DeleteMapping("/employee/{InvoiceNo}")
	public ResponseEntity<?> deleteEmployee(@PathVariable ("InvoiceNo") int InvoiceNo){
		emplservice.deleteEmployee(InvoiceNo);
		//return new ResponseEntity<String>("Employee "+InvoiceNo +" was deleted", HttpStatus.OK);
		return ResponseEntity.ok(Map.of("message","Details of "+InvoiceNo+ " are Deleted"));
		
	}
	

	
	

@PostMapping("/searchEmployee/{InvoiceNo}")
public ResponseEntity<?> getEmployeeByIdName(@PathVariable ("InvoiceNo") int InvoiceNo,@RequestBody Employee employee) throws UserNotFoundException{

	
	return new ResponseEntity<Employee>(emplservice.getEmployeeByIdName(employee,InvoiceNo), HttpStatus.OK);
	
	}
 

	 
//search Employee byId in body
	@PostMapping("/searchData")
	public ResponseEntity<?> fetchData(@RequestBody Employee employee){

		Employee e=emplservice.findById((int)employee.getInvoiceNo());
		
			return new  ResponseEntity<Employee>(e, HttpStatus.OK);
			//throw new  EmptyInputException("Input field is empty");
		
			
		}
		
		
		
		
	}