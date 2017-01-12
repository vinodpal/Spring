/**
 * 
 */
package com.springJdbcJavaBasedConfig;

import org.springframework.jdbc.core.JdbcTemplate;

public class EmployeeDAOImpl implements EmployeeDAO {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.springJdbcJavaBasedConfig.EmployeeDAO#getEmployeeName(int)
	 */
	@Override
	public String getEmployeeName(int id) {
		String sql = "select name from Employee where id = ?";
		String name = jdbcTemplate.queryForObject(sql, new Object[] { id }, String.class);
		return name;
	}

	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

}
