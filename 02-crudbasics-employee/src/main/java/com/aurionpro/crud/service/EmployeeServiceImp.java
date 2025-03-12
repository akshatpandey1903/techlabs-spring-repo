package com.aurionpro.crud.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.aurionpro.crud.dto.PageResponse;
import com.aurionpro.crud.entity.Employee;
import com.aurionpro.crud.entity.Role;
import com.aurionpro.crud.exceptions.EmployeeApiException;
import com.aurionpro.crud.repository.EmployeeRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EmployeeServiceImp implements EmployeeService{
	
	@Autowired
	private EmployeeRepository empRepo;
	
	private static final Logger Log = LoggerFactory.getLogger(EmployeeServiceImp.class);

	@Override
	public PageResponse<Employee> getAllEmployees(int pageSize, int pageNumber, String name) {
		// TODO Auto-generated method stub
		Pageable pageable = PageRequest.of(pageNumber, pageSize);
		Page<Employee> employees = null;
		if(name==null) {
			employees = empRepo.findAll(pageable);
		}
		if(name!=null) {
			employees = empRepo.findByName(name, pageable);
		}
		PageResponse<Employee> pageResponse = new PageResponse<>();
		pageResponse.setContent(employees.getContent());
		pageResponse.setLast(employees.isLast());
		pageResponse.setPageSize(employees.getSize());
		pageResponse.setTotalPages(employees.getTotalPages());
		pageResponse.setTotalElements(employees.getTotalElements());
		return pageResponse;
	}

	@Override
	public Employee addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		Employee empDb = empRepo.save(employee);
		Log.info("Employee added with id:" + employee.getEmpId());
		return empDb;
	}

	@Override
	public void deleteEmployee(Employee employee) {
		// TODO Auto-generated method stub
		empRepo.delete(employee);
		Log.info("Employee with id:" + employee.getEmpId() + " deleted succesfully");
	}

	@Override
	public Employee getEmployeeById(int empId) {
		// TODO Auto-generated method stub
		Optional<Employee> employeeDb = empRepo.findById(empId);
		
		if(employeeDb.isEmpty()) {
			throw new EmployeeApiException("Incorrect employee Id");
		}
		
		return employeeDb.get();
	}

//	@Override
//	public List<Employee> getEmployeesByName(String name) {
//		return empRepo.findByName(name);
//	}

	@Override
	public List<Employee> getEmployeesByRole(Role role) {
		// TODO Auto-generated method stub
		return empRepo.findByRole(role);
	}
	
}
