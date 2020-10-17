package com.cg.eis.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cg.eis.bean.Employee;
import com.cg.eis.enums.Designation;
import com.cg.eis.enums.InsuranceScheme;

public class EmployeeServiceImpl implements EmployeeService {

	Map<Integer, Employee> allEmployees = new HashMap<>();
	
	@Override
	public Employee addEmployee(Employee employee) {
		
		if(allEmployees.isEmpty()) {
			employee.setId(1001);
		}else {
			employee.setId(1000 + allEmployees.size() + 1);
		}
		
		if(employee.getSalary()>5000 && employee.getSalary()<20000) {
			employee.setDesignation(Designation.SYSTEM_ASSOCIATE);
			employee.setScheme(InsuranceScheme.SCHEME_C);
		}else if(employee.getSalary()>=20000 && employee.getSalary()<40000) {
			employee.setDesignation(Designation.PROGRAMMER);
			employee.setScheme(InsuranceScheme.SCHEME_B);
		}else if(employee.getSalary()>=40000) {
			employee.setDesignation(Designation.MANAGER);
			employee.setScheme(InsuranceScheme.SCHEME_A);
		}else {
			employee.setDesignation(Designation.CLERK);
			employee.setScheme(InsuranceScheme.SCHEME_NO);
		}
		
		allEmployees.put(employee.getId(), employee);
		return employee;
	}

	@Override
	public List<Employee> fetchEmployeeByScheme(int schemeOption) {
		
		List<Employee> schemeEmployees = new ArrayList<Employee>();
		
		InsuranceScheme enteredScheme = InsuranceScheme.SCHEME_NO;
		if(schemeOption == 1) {
			enteredScheme = InsuranceScheme.SCHEME_A;
		}else if(schemeOption == 2) {
			enteredScheme = InsuranceScheme.SCHEME_B;
		}else if(schemeOption == 3) {
			enteredScheme = InsuranceScheme.SCHEME_C;
		}
		
		for(Map.Entry<Integer, Employee> entry : allEmployees.entrySet()) {
			Employee empValue = entry.getValue();
			if(empValue.getScheme().ordinal() == schemeOption) {
				schemeEmployees.add(empValue);
			}
		}
		
		return schemeEmployees;
	}

	@Override
	public boolean deleteEmployee(int id) {
		boolean flag = false;
		
		for(Map.Entry<Integer, Employee> entry : allEmployees.entrySet()) {
			if(entry.getKey() == id) {
				allEmployees.remove(id);
				flag = true;
			}
		}
		return flag;
	}

}
