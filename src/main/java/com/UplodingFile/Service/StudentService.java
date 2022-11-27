package com.UplodingFile.Service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.UplodingFile.Entity.Employee;
import com.UplodingFile.Entity.Student;
import com.UplodingFile.Exception.UserNotFoundException;
import com.UplodingFile.Repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository studentRepository;
	
		
	String line="";

	

public void saveStudents()  {
	try {
		BufferedReader br=new BufferedReader(new FileReader("src/main/resources/Students.csv"));
	while((line=br.readLine())!=null) {
		String []data=line.split(",");
		Student s=new Student();
		
		s.setBatchName(data[0]);
		s.setStudentName(data[1]);
		s.setArea(data[2]);
		s.setPercentage(data[3]);
		s.setGrade(data[4]);
		
		studentRepository.save(s);
	}
	
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}



public List<Student> getAllStudents() {
	// TODO Auto-generated method stub
	List<Student>studlist=(List<Student>) studentRepository.findAll();
	if(studlist.isEmpty()) {
		throw new UserNotFoundException("List is empty, please upload the file");
	}
	
	else if(studlist.equals(null)) {
		throw new UserNotFoundException("please upload the file to see the data");
		
	}
		
	return studlist;
	//return (List<Student>) this.studentRepository.findAll();
}



}
