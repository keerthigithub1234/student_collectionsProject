package com.jsp.student;

import java.util.Scanner;
import com.customexception.*;

public class Solution {

	//main class
	public static void main(String[] args) {

		Scanner sc=new Scanner(System.in);

		StudentManagementSystem sms= new StudentManagementSystemImpl();

		System.out.println("-----------Welcome to Student Management System-----------");
		System.out.println();
		while(true)
		{
			System.out.println("1:addStudent");
			System.out.println("2:displayStudent");
			System.out.println("3:displayAllStudents");
			System.out.println("4:removeStudent");
			System.out.println("5:removeAllStudents");
			System.out.println("6:updateStudent");
			System.out.println("7:countStudent");
			System.out.println("8:sortStudents");
			System.out.println("9:getStudentWithHighestMarks");
			System.out.println("10:getStudentWithLowestMarks");
			System.out.println("11:Exit");

			System.out.println();
			System.out.println("Enter the choice:");
			int choice=sc.nextInt();


			switch(choice)
			{
			case 1:sms.addStudent();
			break;

			case 2:sms.displayStudent();
			break;

			case 3:sms.displayAllStudents();
			break;

			case 4:sms.removeStudent();
			break;

			case 5:sms.removeAllStudents();
			break;

			case 6:sms.updateStudent();
			break;

			case 7:sms.countStudent();
			break;

			case 8:sms.sortStudents();
			break;

			case 9:sms.getStudentWithHighestMarks();
			break;

			case 10:sms.getStudentWithLowestMarks();
			break;

			case 11: System.out.println("Thank You!!!!!!!");
			System.exit(0);

			default:{
				try {
					String message = "Enter valid choice Please";
					throw new InvalidChoiceException(message); // invoke
					
					
				}
				catch (Exception e)
				{
					System.out.println(e.getMessage());
				}
			}
			}

		}

	}

}
