package com.vk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vk.dao.EmployeeDao;
import com.vk.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	public EmployeeDao employeeDao;
	
	@Override
	public int save(Employee p) {
		// TODO Auto-generated method stub
		return employeeDao.save(p);
	}

	@Override
	public int update(Employee p) {
		// TODO Auto-generated method stub
		return employeeDao.update(p);
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return employeeDao.delete(id);
	}

	@Override
	public Employee getEmpById(int id) {
		// TODO Auto-generated method stub
		return employeeDao.getEmpById(id);
	}

	@Override
	public List<Employee> getEmployees() {
		// TODO Auto-generated method stub
		return employeeDao.getEmployees();
	}

}
