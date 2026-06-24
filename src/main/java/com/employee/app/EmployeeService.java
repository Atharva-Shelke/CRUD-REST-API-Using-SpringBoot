package com.employee.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository repository;

	public List<Employee> getAll() {

		return repository.findAll(Sort.by("id").ascending());
	}

	public Employee create(Employee employee) {
		return repository.save(employee);
	}

	public Employee getById(int id) {
		return repository.findById(id).orElseThrow(() -> new RuntimeException("Employee not found"));
	}

	public void update(Employee emp) {
		repository.save(emp);
	}

	public void delete(int id) {
		repository.deleteById(id);
	}

	public Page<Employee> getEmployees(int page, int size) {

		Pageable pageable = PageRequest.of(page, size, Sort.by("id").ascending());

		return repository.findAll(pageable);
	}
}
