package com.cg.eis.bean;

import com.cg.eis.enums.Designation;
import com.cg.eis.enums.InsuranceScheme;

public class Employee {
	
	private int id;
	private String name;
	private long salary;
	private Designation designation;
	private InsuranceScheme scheme;
	
	public Employee(String name, long salary) {
		super();
		this.name = name;
		this.salary = salary;
	}

	public Employee(int id, String name, long salary, Designation designation, InsuranceScheme scheme) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.designation = designation;
		this.scheme = scheme;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getSalary() {
		return salary;
	}

	public void setSalary(long salary) {
		this.salary = salary;
	}

	public Designation getDesignation() {
		return designation;
	}

	public void setDesignation(Designation designation) {
		this.designation = designation;
	}

	public InsuranceScheme getScheme() {
		return scheme;
	}

	public void setScheme(InsuranceScheme scheme) {
		this.scheme = scheme;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + ", designation=" + designation
				+ ", scheme=" + scheme + "]";
	}
	
	

}
