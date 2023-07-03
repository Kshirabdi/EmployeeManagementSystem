package com.kshirabditanaya.empapp;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		EmployeeDaoIntrf dao = new EmployeeDaoImpl();
		System.out.println("Welcome to Employee management application...");
		
		int id;
		String name;
		int ch;
		Scanner sc= new Scanner (System.in);
		do {
			System.out.println("1.Add Employee\n"+
								"2.Show all Employees\n"+
								"3.Show all Employee based on id\n"+
								"4.Update the Employee\n"+
								"5.Delete the Employee\n"+
								"6.Exit");
			System.out.print("Enter choice = ");
			ch=sc.nextInt();
			switch(ch)
			{
			case 1:
				Employee emp = new Employee();
				System.out.println("Enter Id : " );
				id = sc.nextInt();
				System.out.println("Enter name : ");
				sc.nextLine();
				name = sc.nextLine();
				System.out.println("Enter salary : ");
				double salary = sc.nextDouble();
				System.out.println("Enter age : ");
				int age = sc.nextInt();
				emp.setId(id);
				emp.setName(name);
				emp.setSalary(salary);
				emp.setAge(age);
				dao.createEmployee(emp);
				break;
			case 2:
				dao.showAllEmployee();
				break;
			case 3 :
				System.out.println("Enter Id to show the details = ");
				id = sc.nextInt();
				dao.showEmployeeBasedOnId(id);
				break;
			case 4 :
				System.out.println("Enter id to update the details : ");
				id=sc.nextInt();
				
				
				do {
					System.out.println("1.Update name\n"+
										"2.Update salary\n"+
										"3.Update age\n");
					System.out.print("Enter choice = ");
					ch=sc.nextInt();
					
				}while(ch>3 && ch<1);
					switch(ch)
					{
					case 1:
						System.out.println("Enter the new name to Update : ");
						sc.nextLine();
						name = sc.nextLine();
						dao.updateEmployee(id, name);
						
						break;
					case 2:
						System.out.println("Enter the new salary to Update : ");
						salary = sc.nextDouble();
						dao.updateEmployee(id, salary);
						
						break;
					case 3 :
						System.out.println("Enter the new age to Update : ");
						age = sc.nextInt();
						dao.updateEmployee(id, age);
						break;
					default:
						System.out.println("Enter valid choice!! ");
						break;
						
					}
					break;
					
				
				
				
			case 5 :
				System.out.println("Enter the employee id to delete the employee details : ");
				id = sc.nextInt();
				dao.deleteEmployee(id);
				break;
			case 6:
				System.out.println("\nThank you using our application");
				System.exit(0);
			
			default:
				System.out.println("Enter valid choice = ");
				break;
				
			}
			
		}while(true);

	}

}
