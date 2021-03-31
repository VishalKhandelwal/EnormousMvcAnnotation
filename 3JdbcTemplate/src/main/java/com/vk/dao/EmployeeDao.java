package com.vk.dao;

import java.util.List;

import com.vk.model.Employee;

public interface EmployeeDao {

	public int save(Employee p);
	public int update(Employee p);
	public int delete(int id);
	public Employee getEmpById(int id);
	public List<Employee> getEmployees();
}
