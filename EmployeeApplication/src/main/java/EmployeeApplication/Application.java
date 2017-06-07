package EmployeeApplication;

import java.sql.Date;
import java.sql.SQLException;
import java.util.Scanner;

import POJO.*;
import service.*;

public class Application {
	public static void main(String[] args) throws SQLException {
		System.out.println("Please enter the name of the employee to get details");
		Scanner sc=new Scanner(System.in);
		int empNo=sc.nextInt();
		Employee employee=EmployeeService.getEmployeeInfo(empNo);
		System.out.println("Employee Number is "+employee.getEmp_no());
		System.out.println("FirstName:"+employee.getFirst_name());
		System.out.println("LastName:"+employee.getLast_name());
		System.out.println("Gender:"+employee.getGender());
		System.out.println("Date of Birth:"+employee.getBirth_date());
		System.out.println("HireDate:"+employee.getHire_date());
		int salary=EmployeeService.getSalary(empNo);
		System.out.println("Salary is "+salary);


		
	}
}
