package com.sahan.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sahan.demo.modal.Address;
import com.sahan.demo.modal.Employee;
import com.sahan.demo.repository.EmployeeRepository;
import com.sahan.demo.service.EmployeeService;

@RestController
@RequestMapping(value = "/emscloud")
public class EmployeeController {
	@Autowired
	EmployeeService employeeRepository;
	
	@RequestMapping(value = "/employee", method = RequestMethod.POST)
	public Employee save(@RequestBody Employee employee) {
		
		return employeeRepository.save(employee);
	}

	@RequestMapping(value = "/test")
	public Employee test() {
		Employee employee = new Employee();
		employee.setId(1);
		employee.setName("sahan");
		Address address = new Address();
		address.setId(1);
		address.setCity("ja-ela");
		address.setTown("Bopitiya");
		employee.setAddress(address);
		
		return employee;
	}
	@RequestMapping(value = "/test2")
	public ResponseEntity<Employee> test2(){
		Integer x = 2;
		if(x== null) {
			Employee employee = new Employee();
			employee.setId(1);
			employee.setName("sahan");
			Address address = new Address();
			address.setId(1);
			address.setCity("ja-ela");
			address.setTown("Bopitiya");
			employee.setAddress(address);
			return ResponseEntity.ok(employee);
		}else {
			HttpHeaders headers = new HttpHeaders();
			headers.add("status", "Invalid Status");
			return ResponseEntity.notFound().headers(headers).build();
		}
	}
}
