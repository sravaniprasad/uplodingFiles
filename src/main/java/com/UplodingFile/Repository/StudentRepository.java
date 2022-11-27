package com.UplodingFile.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.UplodingFile.Entity.Employee;
import com.UplodingFile.Entity.Student;


public interface StudentRepository extends CrudRepository<Student, Integer> {

	
	
}
