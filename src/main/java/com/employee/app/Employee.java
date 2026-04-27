package com.employee.app;

public class Employee {

	private Integer id;
	private String name;
	private Integer salary;
	private String role;

	public Employee() {
	}

	public Employee(Integer id, String name, Integer salary, String role) {
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.role = role;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getSalary() {
		return salary;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
}