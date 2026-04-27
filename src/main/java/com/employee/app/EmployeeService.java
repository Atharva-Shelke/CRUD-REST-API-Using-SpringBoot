package com.employee.app;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

	private final EmployeeDao dao;

	public EmployeeService(EmployeeDao dao) {
		this.dao = dao;
	}

	public void create(Employee emp) {
		dao.save(emp);
	}

	public List<Employee> getAll() {
		return dao.findAll();
	}

	public Employee getById(int id) {
		return dao.findById(id);
	}

	public void update(Employee emp) {
		dao.update(emp);
	}

	public void delete(int id) {
		dao.delete(id);
	}
}