package com.employee.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employees")
public class MyController {

	@Autowired
	private final EmployeeService service;

	public MyController(EmployeeService service) {
		this.service = service;
	}

	@PostMapping
	public String create(@RequestBody Employee emp) {
		service.create(emp);
		return "Employee created";
	}

	@GetMapping
	public List<Employee> getAll() {
		return service.getAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getById(@PathVariable int id) {
		try {
			Employee emp = service.getById(id);
			return ResponseEntity.ok(emp);
		} catch (RuntimeException e) {
			return ResponseEntity.status(404).body(e.getMessage());
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable int id, @RequestBody Employee emp) {
		try {
			emp.setId(id);
			service.update(emp);
			return ResponseEntity.ok("Employee updated");
		} catch (RuntimeException ex) {
			return ResponseEntity.status(404).body(ex.getMessage());
		}

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable int id) {
		try {
			service.delete(id);
			return ResponseEntity.ok("Employee deleted");
		} catch (RuntimeException e) {
			return ResponseEntity.status(404).body(e.getMessage());
		}
	}
}
