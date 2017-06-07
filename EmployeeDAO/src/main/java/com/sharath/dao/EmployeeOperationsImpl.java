package com.sharath.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import POJO.Department;
import POJO.Employee;
import POJO.Salaries;

public class EmployeeOperationsImpl implements EmployeeOperations {
	static Connection connection;

    {
        try {
            connection = createConnection();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	public Employee getEmployee(int empNo) throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement statement = connection.prepareStatement("select * from employees where emp_no=? ");
        statement.setInt(1,empNo);

        ResultSet resultSet = statement.executeQuery();
     //   ArrayList<Employee> employeeList=new ArrayList<Employee>();
        //use resultset
        Employee employee = new Employee();

        while (resultSet.next()) {
            employee.setEmp_no(resultSet.getInt(1));
            employee.setBirth_date(resultSet.getDate(2));
            employee.setFirst_name(resultSet.getString(3));
            employee.setLast_name(resultSet.getString(4));
            employee.setGender(resultSet.getString(5));
            employee.setHire_date(resultSet.getDate(6));
          //  employeeList.add(employee);
        }
        return employee;
	}

	public EmployeeOperationsImpl() throws SQLException {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getSalary(int empNo) throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement statement = connection.prepareStatement("select avg(salary) from salaries where emp_no="+empNo);
        ResultSet resultSet = statement.executeQuery();
        int salary=0;
     //   ArrayList<Salaries> salaryList=new ArrayList<Salaries>();
        while(resultSet.next()){
//        	Salaries salary=new Salaries();
//        	salary.setEmp_no(resultSet.getInt(1));
//        	salary.setSalary(resultSet.getInt(2));
//        	salary.setFrom_date(resultSet.getDate(3));
//        	salary.setTo_date(resultSet.getDate(4));
//        	salaryList.add(salary);
        	 salary=resultSet.getInt(1);
        }
    	return salary;
	}

	public ArrayList<Department> getDepartment() throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement statement = connection.prepareStatement("select * from salaries");
        ResultSet resultSet = statement.executeQuery();
        ArrayList<Department> departmentList=new ArrayList<Department>();
        while(resultSet.next()){
        	Department department=new Department();
        	department.setDept_no(resultSet.getInt(1));
        	department.setDept_name(resultSet.getString(2));
        	departmentList.add(department);
        	
        }
    	return departmentList;
	}
	private Connection createConnection() throws ClassNotFoundException, SQLException {
        //register driver
   //     Class.forName("com.mysql.jdbc.Driver");

        //establish connection
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employees", "root", "root1234");

        return connection;
    }

}
