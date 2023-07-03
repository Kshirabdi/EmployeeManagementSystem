package com.kshirabditanaya.empapp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EmployeeDaoImpl implements EmployeeDaoIntrf{
    Connection connection;
	@Override
	public void createEmployee(Employee emp) {
		 try {
			connection = DBConnection.createDBConnection();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 String query =  "insert into employeeData values(?,?,?,?)";
		 try {
			PreparedStatement pstm=connection.prepareStatement(query);
			pstm.setInt(1,emp.getId ());
			pstm.setString(2, emp.getName());
			pstm.setDouble(3, emp.getSalary());
			pstm.setInt(4, emp.getAge());
			int rowCount = pstm.executeUpdate();
			if(rowCount != 0)
			{
				System.out.println("Employee added successfully!!!");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void showAllEmployee() {
		try {
			connection = DBConnection.createDBConnection();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String query = "SELECT * FROM EMPLOYEEDATA";
		System.out.println("Employee Details:");
		System.out.println("-------------------------------------------------------------------------------------");
		System.out.format("%s\t%s\t%s\t\t%s\n", "ID","Name","Salary","age");
		System.out.println("-------------------------------------------------------------------------------------");
		try
		{
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next())
			{
				System.out.format("%d\t%s\t%f\t%d\n",rs.getInt(1),rs.getString(2),rs.getDouble(3),rs.getInt(4));
				System.out.println("-------------------------------------------------------------------------------------");
			}
		}catch(Exception e)
		{
			System.out.println(e);
		}
		
		
	}

	@Override
	public void showEmployeeBasedOnId(int id) {
	try {
		connection = DBConnection.createDBConnection();
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		String query = "SELECT * FROM EMPLOYEEDATA WHERE EMPID = "+id;
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next())
			{
				System.out.format("%d\t%s\t%f\t%d\n",rs.getInt(1),rs.getString(2),rs.getDouble(3),rs.getInt(4));
			}
			
		}catch(Exception e)
		{
			System.out.println(e);
		}
		
	}
	/* Method to update employee name*/
	@Override
	public void updateEmployee(int id, String name) {
		try {
			connection =DBConnection.createDBConnection();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String query = "UPDATE EMPLOYEEDATA SET EMPNAME = ? WHERE EMPID = ?";
		try {
			PreparedStatement pstmt = connection.prepareStatement(query);
			pstmt.setString(1,name);
			pstmt.setInt(2, id);
			int cnt = pstmt.executeUpdate();
			if(cnt != 0)
			{
				System.out.println("Employee details updated Successfully ...");
			}
		}catch(Exception e)
		{
			System.out.println(e);
		}
		
		
	}
	/* Method to update employee salary*/
	public void updateEmployee(int id, double salary) {
		try {
			connection =DBConnection.createDBConnection();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String query = "UPDATE EMPLOYEEDATA SET empsalary = ? WHERE EMPID = ?";
		try {
			PreparedStatement pstmt = connection.prepareStatement(query);
			pstmt.setDouble(1,salary);
			pstmt.setInt(2, id);
			int cnt = pstmt.executeUpdate();
			if(cnt != 0)
			{
				System.out.println("Employee details updated Successfully ...");
			}
		}catch(Exception e)
		{
			System.out.println(e);
		}
		
		
	}
	/* Method to update employee age*/
	public void updateEmployee(int id, int age) {
		try {
			connection =DBConnection.createDBConnection();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String query = "UPDATE EMPLOYEEDATA SET empage = ? WHERE EMPID = ?";
		try {
			PreparedStatement pstmt = connection.prepareStatement(query);
			pstmt.setInt(1,age);
			pstmt.setInt(2, id);
			int cnt = pstmt.executeUpdate();
			if(cnt != 0)
			{
				System.out.println("Employee details updated Successfully ...");
			}
		}catch(Exception e)
		{
			System.out.println(e);
		}
		
		
	}

	@Override
	public void deleteEmployee(int id) {
		try {
			connection = DBConnection.createDBConnection();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String query= "DELETE FROM EMPLOYEEDATA WHERE EMPID = ?";
		try {
			PreparedStatement pstmt = connection.prepareStatement(query);
			pstmt.setInt(1,id);
			
			int cnt = pstmt.executeUpdate();
			if(cnt != 0)
			{
				System.out.println("Employee details of Employee id ="+id+"\ndeleted Successfully...");
			}
			
		}catch(Exception e)
		{
			e.fillInStackTrace();
		}
		
		
	}

	
	

}
