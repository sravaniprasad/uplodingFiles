package com.UplodingFile.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.UplodingFile.Entity.Employee;

public interface EmployeeRepo extends JpaRepository<Employee,Integer>{

	@Query("SELECT e FROM Employee e WHERE "+
	"e.empname LIKE CONCAT('%',:query, '%')"+
			"Or e.emprole LIKE CONCAT('%',:query, '%')")
	List<Employee> searchEmployee(String query);


	

	
	}

