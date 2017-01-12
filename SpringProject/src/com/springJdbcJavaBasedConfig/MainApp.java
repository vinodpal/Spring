/**
 * 
 */
package com.springJdbcJavaBasedConfig;

import java.sql.SQLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;


public class MainApp {
	 public static void main(String[] args) throws SQLException {
		 ApplicationContext applicationContext = 
	        		new AnnotationConfigApplicationContext(
	                SpringJDBCConfiguration.class);
	 
	        EmployeeDAO empDAO = applicationContext.getBean(EmployeeDAO.class);
	 
	        String empName = empDAO.getEmployeeName(1);
	 
	        System.out.println("Employee name is " + empName);
	         empName = empDAO.getEmployeeName(5);
	   	 
	        System.out.println("Employee name is " + empName);
	         empName = empDAO.getEmployeeName(7);
	 
	        System.out.println("Employee name is " + empName);
	        ((AbstractApplicationContext) applicationContext).close();
	    }
}
