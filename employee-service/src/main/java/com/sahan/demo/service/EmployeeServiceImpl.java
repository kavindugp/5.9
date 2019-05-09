package com.sahan.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sahan.demo.modal.Employee;
import com.sahan.demo.modal.Telephone;
import com.sahan.demo.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;
	
	@Override
	public Employee save(Employee employee) {
		
		for(Telephone telephone:employee.getTelephones()) {
			telephone.setEmployee(employee);
		}
		
		return employeeRepository.save(employee);
	}
}
