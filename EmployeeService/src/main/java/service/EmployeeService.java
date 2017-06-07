package service;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import com.sharath.dao.*;
import POJO.*;

public class EmployeeService {
	public static EmployeeOperations getInstance() throws SQLException{
	EmployeeOperations employeeOperationsImpl=new EmployeeOperationsImpl();
	return employeeOperationsImpl;
	}
public static Employee  getEmployeeInfo(int empNo) throws SQLException{
	Employee emp=EmployeeService.getInstance().getEmployee(empNo );
	return emp;
	
}

public static int getSalary(int empNo) throws SQLException {
	// TODO Auto-generated method stub
	int sal=EmployeeService.getInstance().getSalary(empNo);
	return sal;
}


}
