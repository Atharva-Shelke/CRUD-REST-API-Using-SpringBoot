package com.employee.app;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDao {

	private final JdbcTemplate jdbcTemplate;
	private static final RowMapper<Employee> ERM = new EmployeeRowMapper();

	public EmployeeDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public int save(Employee emp) {
		String sql = "INSERT INTO employee(name, salary, role) VALUES (?, ?, ?)";
		return jdbcTemplate.update(sql, emp.getName(), emp.getSalary(), emp.getRole());
	}

	public List<Employee> findAll() {
		String sql = "SELECT * FROM employee ORDER BY id";
		return jdbcTemplate.query(sql, ERM);
	}

	public Employee findById(int id) {
		String sql = "SELECT * FROM employee WHERE id = ?";

		try {
			return jdbcTemplate.queryForObject(sql, ERM, id);
		} catch (org.springframework.dao.EmptyResultDataAccessException e) {
			throw new RuntimeException("Employee not found with id: " + id);
		}
	}

	public void update(Employee emp) {
		String sql = "UPDATE employee SET name=?, salary=?, role=? WHERE id=?";

		int rows = jdbcTemplate.update(sql, emp.getName(), emp.getSalary(), emp.getRole(), emp.getId());

		if (rows == 0) {
			throw new RuntimeException("Employee not found for update with id: " + emp.getId());
		}
	}

	public void delete(int id) {
		String sql = "DELETE FROM employee WHERE id=?";

		int rows = jdbcTemplate.update(sql, id);

		if (rows == 0) {
			throw new RuntimeException("Employee not found for delete with id: " + id);
		}
	}
}