package com.cg.eis.service;

import java.util.List;

import com.cg.eis.bean.Employee;

public interface EmployeeService {
	
	Employee addEmployee(Employee employee);
	List<Employee> fetchEmployeeByScheme(int schemeOption);
	boolean deleteEmployee(int id);

}
