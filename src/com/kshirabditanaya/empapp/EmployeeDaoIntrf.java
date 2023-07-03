package com.kshirabditanaya.empapp;

public interface EmployeeDaoIntrf {
	//create employee
	public void createEmployee(Employee emp);
	//show all employee
	public void showAllEmployee();
	//show employee based on id
	public void showEmployeeBasedOnId(int id);
	//update employee name
	public void updateEmployee(int id,String name);
	//update employee name
	public void updateEmployee(int id,double salary);
	//update employee name
	public void updateEmployee(int id,int age);
	//delete employee
	public void deleteEmployee(int id);
	
}
