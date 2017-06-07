package com.sharath.dao;
import java.sql.SQLException;
import java.util.ArrayList;

import POJO.*;

public interface EmployeeOperations {
public  Employee getEmployee(int empNo) throws SQLException;
public int getSalary(int empNo) throws SQLException;
public ArrayList<Department> getDepartment() throws SQLException;
}
