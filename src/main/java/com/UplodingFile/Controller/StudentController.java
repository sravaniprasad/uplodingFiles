package com.UplodingFile.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.UplodingFile.Entity.Student;
import com.UplodingFile.Service.StudentService;
@RestController
public class StudentController {

	@Autowired
	private StudentService studentService;

 
	
	@PostMapping("/studentData")
	public ResponseEntity<?> setData() {
		this.studentService.saveStudents();
		return ResponseEntity.ok(Map.of("message","Data is inserted into Database"));
		
	}
	
	@GetMapping("/students")
	public List<Student> getAllstudent(){
		return this.studentService.getAllStudents();
	}
}
