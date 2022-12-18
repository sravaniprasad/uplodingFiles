package com.UplodingFile.ServiceImplementation;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.UplodingFile.Entity.Employee;
import com.UplodingFile.Exception.ResourceNotFoundException;
import com.UplodingFile.Exception.UserNotFoundException;
import com.UplodingFile.Repository.EmployeeRepo;
import com.UplodingFile.Service.EmplService;
@Service
public class EmployeeServiceImpl implements EmplService{
	private EmployeeRepo emprepo;
	
	public EmployeeServiceImpl(EmployeeRepo emprepo) {
		super();
		this.emprepo=emprepo;
	}
	@Override
	public List<Employee> getAllEmployees(){
		List<Employee>emplist=emprepo.findAll();
		if(emplist.isEmpty())
			throw new UserNotFoundException("List is empty, please upload the file");
		return emplist;
		//return this.empRepo.findAll();
	}
	@Override
	public Employee saveEmployee(Employee employee) {
		// TODO Auto-generated method stub
		
		return emprepo.save(employee);
	}
	@Override
	public List<Employee> searchEmployee(String query) {
		// TODO Auto-generated method stub
	List<Employee> employe=	emprepo.searchEmployee(query);
	return employe;
	}
    @Override
	public Employee getEmployeeById(Integer InvoiceNo) {
		// TODO Auto-generated method stub
	return emprepo.findById(InvoiceNo).orElseThrow(()->new UserNotFoundException("Employee Not Found with "+InvoiceNo));
	
	}
	@Override
	public Employee UpdateEmployee(Employee employee, Integer InvoiceNo) {
		// TODO Auto-generated method stub
		
		Employee existingemployee=emprepo.findById(InvoiceNo).orElseThrow(
				()->new ResourceNotFoundException("Employee","InvoiceNo",InvoiceNo));
		existingemployee.setEmpname(employee.getEmpname());
		existingemployee.setEmpaddress(employee.getEmpaddress());
		existingemployee.setEmprole(employee.getEmprole());
		emprepo.save(existingemployee);
		//emprepo.findById(InvoiceNo).orElseThrow(()->new UserNotFoundException("Employee Not found with this id"));
		return existingemployee;
	}
	@Override
	public void deleteEmployee(int InvoiceNo) {
		// TODO Auto-generated method stub
		
		emprepo.findById(InvoiceNo).orElseThrow(()->new ResourceNotFoundException("Employee","InvoiceNo",InvoiceNo));
		
		emprepo.deleteById(InvoiceNo);
		
	}
	@Override
	public Employee findById(int invoiceNo) {
		// TODO Auto-generated method stub
		Optional<Employee>emp=emprepo.findById(invoiceNo);
		if(emp.isPresent()) {
			return emp.get();
			
		}
	
			return emp.orElseThrow(()->new ResourceNotFoundException("Employee","empNo",invoiceNo));
		
	}
}

