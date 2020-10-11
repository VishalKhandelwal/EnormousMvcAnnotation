package com.vk.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.RowMapper;

import com.vk.model.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public int save(Employee p)
	{
		//String sql = "insert into emp99(name,salary,designation) values('"+p.getName()+"',"+p.getSalary()+",'"+p.getDesignation()+"')";
		//System.err.println(sql);
		//return jdbcTemplate.update(sql);
		
		//return jdbcTemplate.update("insert into emp99(name,salary,designation) values(?,?,?)",p.getName(),p.getSalary(),p.getDesignation());
		return jdbcTemplate.update("CALL saveEmp99(?,?,?);",p.getName(),p.getSalary(),p.getDesignation());
	}
	
	@Override
	public int update(Employee p)
	{
		//String sql = "update emp99 set name='"+p.getName()+"',salary="+p.getSalary()+",designation='"+p.getDesignation()+"' where id="+p.getId()+"";
		//System.err.println(sql);
		//return jdbcTemplate.update(sql);
		
		//return jdbcTemplate.update("update emp99 set name=?,salary=?,designation=? where id=?",p.getName(),p.getSalary(),p.getDesignation(),p.getId());
		return jdbcTemplate.update("CALL updateEmp99(?,?,?,?);",p.getId(),p.getName(),p.getSalary(),p.getDesignation());

	}
	
	@Override
	public int delete(int id)
	{
		//String sql = "delete from emp99 where id = "+id+"";
		//System.err.println(sql);
		//return jdbcTemplate.update(sql);
		//return jdbcTemplate.update("delete from emp99 where id = ?",id);
		return jdbcTemplate.update("CALL deleteEmp99ById(?);",id);
	}
	
	@Override
	public Employee getEmpById(int id)
	{
		//String sql = "select * from emp99 where id=?";
		String sql = "CALL getEmp99ById(?);";   //using store procedure
		
		System.err.println(sql);		
		return jdbcTemplate.queryForObject(sql, new Object[] {id}, new BeanPropertyRowMapper<>(Employee.class));
	}
	
	@Override
	public List<Employee> getEmployees(){
		//return jdbcTemplate.query("select * from emp99", new RowMapper<Employee>() {
		return jdbcTemplate.query("call getAllEmp99();", new RowMapper<Employee>() {     //using store procedure

			@Override
			public Employee mapRow(ResultSet rs, int row) throws SQLException {
				Employee e = new Employee();
				e.setId(rs.getInt(1));
				e.setName(rs.getString(2));
				e.setSalary(rs.getFloat(3));
				e.setDesignation(rs.getString(4));
				return e;
			}
		});
	}
}
