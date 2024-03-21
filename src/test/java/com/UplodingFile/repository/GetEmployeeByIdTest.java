package com.UplodingFile.repository;

import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import com.UplodingFile.Entity.Employee;
import com.UplodingFile.Repository.EmployeeRepo;
@SpringBootTest
//@DataJpaTest
//@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class GetEmployeeByIdTest {
	
	@Autowired
	private EmployeeRepo emprepo;
	
	// @Test
	// @Order(1)
	// @Rollback(value=false)
	// public void saveEmployeeTest() {	
	// 	Employee e=new Employee(23,"kappa","india","md");
	// 	emprepo.save(e);
	// 	Assertions.assertThat(e.getInvoiceNo()).isGreaterThan(0);
		
	// }
	
	@Test
	@Order(2)
	public void getEmployeeTest() {
		Employee e=emprepo.findById(2).get();
		Assertions.assertThat(e.getInvoiceNo()).isEqualTo(2);
		
	}
	
	    @Test
	    @Order(3)
	    public void getListOfEmployeesTest(){
	        List<Employee> employees = emprepo.findAll();
	        Assertions.assertThat(employees.size()).isGreaterThan(0);

	    }
	  
	    @Test
	    @Order(4)
	    @Rollback(value = false)
	    public void updateEmployeeTest(){
	        Employee employee = emprepo.findById(11).get();
	        employee.setEmpname("siya");
	        Employee empUpdated =  emprepo.save(employee);
	        Assertions.assertThat(empUpdated.getEmpname()).isEqualTo("siya");

	    }
	    
	    
	//     @Test
	//     @Order(5)
	//     @Rollback(value = false)
	//     public void deleteEmployeeTest(){

	//         Employee employee = emprepo.findById(18).get();
	//         emprepo.delete(employee);
	//         //employeeRepository.deleteById(1L);
	//         Employee employee1 = null;
	//         Optional<Employee> optionalEmployee = emprepo.findById(18);
	//         if(optionalEmployee.isPresent()){
	//             employee1 = optionalEmployee.get();
	//         }
	//         Assertions.assertThat(employee1).isNull();
	//     }
	// }
}    
	 
//	@BeforeEach
//	void setUp() {
//		Optional<Employee> emp=Optional.of(new Employee(1,"srav","mysore","md"));
//	  Mockito.when(emprepo.findById(1)).thenReturn(emp);
//	
//	}
//	@Test
//	public void testbyId() {
//		
//		String empname="srav";
//		Employee e=emplserv.getEmployeeById(1);
//		assertEquals(empname, e.getEmpname());
//		//assertThrows(null, null);
//		assertThrows(UserNotFoundException.class, ()->emplserv.getEmployeeById(11)," Employee not found");
//		}
	
	

	
//	@Test
//	public void ThrowsWithExceptionbyId() {
//		//EmployeeServiceImpl empserv =new EmployeeServiceImpl(emprepo);
//	mockMvc.perform(post("/markdown-items/search").contentType(APPLICATION_JSON_UTF8).content(filter))
//	.andExpect(status().isOk());
	
//		Employee e1=new Employee(1,"siya","goa","md");
//		emplserv.saveEmployee(e1);
//		
//		assertThrows(UserNotFoundException.class, ()->emplserv.getEmployeeById(11)," Employee not found");
//	assertEquals();
//	}
	
	
//	@Test
//	public void shouldThrowErrorwhileGettingMarkdownItems() throws Exception {
//		doThrow(new DataAccessResourceFailureException("Mongo exception error message")).when(markdownItemService)
//				.getFilteredMarkdownItems(any(ItemSearchCriteria.class));
//		String searchCriteria = new ObjectMapper().writeValueAsString(new ItemSearchCriteria());
//		mockMvc.perform(post("/markdown-items/search").contentType(APPLICATION_JSON_UTF8).content(searchCriteria))
//				.andExpect(status().isInternalServerError())
//				.andExpect(content().string(containsString("Mongo exception error message")));
//	}
	
