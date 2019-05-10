package com.example.demo.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.modal.Address;
import com.example.demo.modal.Employee;

@RestController

@RequestMapping(value="/emscloud")
public class EmployeeController {

	@RequestMapping(value = "/test")
	public Employee test() {
		
		Employee employee=new Employee();
	    employee.setId(1);
	    employee.setName("Ama");
	 	Address address = new Address(); 
	    address.setAddress("Kaduwela");
	    address.setId(2);
	    address.setCity("Kadawatha");
	    employee.setAddress(address);
	    return employee;
		
		
	}
	
	
	@RequestMapping(value = "/test1")
	public ResponseEntity<Employee> test1() {
	Integer x=2;	
	if (x==null)
	{
		Employee employee=new Employee();
	    employee.setId(1);
	    employee.setName("Ama");
	 	Address address = new Address(); 
	    address.setAddress("Kaduwela");
	    address.setId(2);
	    address.setCity("Kadawatha");
	    employee.setAddress(address);
	    return ResponseEntity.ok(employee);
	}
	
	else {
	HttpHeaders httpHeaders = new HttpHeaders()	;
	httpHeaders.add("status", "invalid status");
	return ResponseEntity.notFound().headers(httpHeaders).build();
	}	
		
	
	
}
}
