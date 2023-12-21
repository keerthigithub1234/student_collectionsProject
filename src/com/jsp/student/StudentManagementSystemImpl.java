package com.jsp.student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import com.customexception.InvalidChoiceException;
import com.customexception.StudentNotFoundException;

import customsorting.SortStudentByAge;
import customsorting.SortStudentById;
import customsorting.SortStudentByMarks;
import customsorting.SortStudentByName;

public class StudentManagementSystemImpl implements StudentManagementSystem {

	//implementation class

	Scanner sc= new Scanner(System.in);

	/**
	 * we are using Collection as our database
	 * I use Map Collection type->LinkedHashMap    
	 * where map uses key and value ,easy to sort
	 * key is<String> ->Student Id
	 * value is<Student> ->Student Object
	 *
	 */

	Map<String,Student> map = new LinkedHashMap<String,Student>();


	@Override
	public void addStudent()
	{
		//Accepting Age
		System.out.println("Enter Age :");
		int a=sc.nextInt();
		//Accepting Student Name
		System.out.println("Enter Name :");
		String n=sc.next();
		//Accepting Marks
		System.out.println("Enter Marks :");
		int m=sc.nextInt(); 


		//Creating Student Instance
		Student std=new Student(n,a,m);
		//Adding Student details to Collection database
		map.put(std.getId(), std);

		System.out.println("Student Record Inserted Succesfully!!!");
		System.out.println("Your Student Id is :"+ std.getId());
		System.out.println();
	}
	@Override
	public void displayStudent()
	{
		//Accepting student id and converting into uppercase
		//because Id should be considered  as valid -> jsp101,Jsp101,JSP101
		System.out.println("Enter the Student Id:");
		String id = sc.next(); //String id = sc.nect().toUpperCase();
		id = id.toUpperCase();

		if(map.containsKey(id))
		{
			System.out.println("Student Record Found");
			Student std = map.get(id);   // getting student object
			System.out.println("id is :" + std.getId());
			System.out.println("Age is :"+std.getAge());
			System.out.println("Marks is :" +std.getMarks());
		}
		else
		{
			try {
				String message  = "Student record with Id " +id +" not found";
				throw  new StudentNotFoundException(message);
			}
			catch(Exception e ){
				System.out.println(e.getMessage());
			}
		}
		System.out.println();
	}
	@Override
	public void removeStudent()
	{
		//Accept id and convert to Upper case
		System.out.println("Enter the Student id:");
		String id =sc.next().toUpperCase();


		if(map.containsKey(id))
		{
			System.out.println("Student Record Found");
			map.remove(id);
			System.out.println("Student is removed successfully !!");
		}
		else
		{
			try {
				String message = "Student id with " +id+" Not Found";
				throw new StudentNotFoundException(message);

			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		}

		System.out.println();
	}
	@Override
	public void removeAllStudents()
	{
		if(!map.isEmpty())
		{
			System.out.println("no of students before deleting " +map.size());
			map.clear();
			System.out.println("no of students after deleting" +map.size());
			System.out.println("student record deleted successfully");
		}
		else
		{
			try {
				String message="No Student records to delete!!";
				System.out.println();
				throw new StudentNotFoundException(message);
			}
			catch(Exception e){
				System.out.println(e.getMessage());

			}
		}
	}
	@Override
	public void displayAllStudents()
	{

		/**
		 * Checking if the database is Empty are not(database is map 
		 * if-> if database is not empty ->Display Student Record(Object)
		 * else-> database is empty ->throw an exception
		 * 
		 */

		if(!map.isEmpty())
		{
			System.out.println("----Student Record are as follows----");
			System.out.println();

			//converting map into set (bcz can't traverse in map)
			Set<String> keys = map.keySet();    //JSP101 JSP102 JSP103

			for(String key:keys)
			{
				//printing reference variable as toString() is Overridden
				System.out.println(map.get(key));
			}
		}
		else
		{
			try {
				String message="No Student records present to display!!";
				System.out.println();
				throw new StudentNotFoundException(message);
			}
			catch(Exception e){
				System.out.println(e.getMessage());

			}
		}
	}

	@Override
	public void updateStudent()
	{
		// Accept Student Id,convert toUppercase
		System.out.println("Enter the Student Id :");
		String id = sc.next().toUpperCase();

		//check if id is present or not using containskey()

		if(map.containsKey(id))
		{
			System.out.println("Student Record  Found");
			Student std= map.get(id);

			System.out.println("1:UpdateAge: \n 2:UpdateName: ");
			System.out.println("3:UpdateMarks: \n Enter choice: \n ");
			int choice = sc.nextInt();

			switch(choice)
			{
			case 1 : System.out.println("Enter the Age :");
			int age = sc.nextInt();
			std.setAge(age);
			System.out.println("Age Updated Successfully");
			break;

			case 2 : System.out.println("Enter the Name :");
			int name = sc.nextInt();
			std.setAge(name);
			System.out.println("Name Updated Successfully");
			break;

			case 3 : System.out.println("Enter the Marks :");
			int marks = sc.nextInt();
			std.setAge(marks);
			System.out.println("Marks Updated Successfully");
			break;



			default : try {
				String message = "Invalid choice.kindly enter the valid choice";
				throw new InvalidChoiceException(message);
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());

			}
			}
		}

		else
		{
			try {
				String message = "Student id with " +id+" Not Found";
				throw new StudentNotFoundException(message);

			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}

		}
		System.out.println();



	}
	@Override
	public void countStudent()
	{
		System.out.println("Count of the  Students are :" +map.size());
		System.out.println();

	}
	@Override
	public void sortStudents()
	{
		if(map.size()>=2)
		{
			// reference of List & Object of ArrayList sorting Student Object
			List<Student> list = new ArrayList<Student>();

			//Converting map(Map) into Set using keySet()
			Set<String>keys =  map.keySet(); //JSP101 JSP102 JSP103

			//Traversing Keys (Ids)
			for(String key:keys)
			{
				Student std= map.get(key); //getting Student Object
				list.add(std);  //Adding Student Object into List
				//list.add(map.get(key));
			}

			System.out.println("1:Sort Student by Id");
			System.out.println("2:Sort Student by Age");
			System.out.println("3:Sort Student by Name");
			System.out.println("4:Sort Student by Marks");

			System.out.println("enter the choice");
			int choice = sc.nextInt();

			switch(choice)
			{

			case 1: Collections.sort(list,new SortStudentById());
			for(Student s:list)
			{
				System.out.println(s);
			}
			break;

			case 2: Collections.sort(list,new SortStudentByAge());
			for(Student s:list)
			{
				System.out.println(s);
			}
			break;

			case 3: Collections.sort(list,new SortStudentByName());
			for(Student s:list)
			{
				System.out.println(s);
			}
			break;

			case 4: Collections.sort(list,new SortStudentByMarks());
			for(Student s:list)
			{
				System.out.println(s);
			}
			break;
			default: 
				try
				{
					String message="Invalid choice!!! please enter the valid choice";
					throw new InvalidChoiceException(message);
				}
				catch(Exception e)
				{
					System.out.println(e.getMessage());
				}
			}
		}
		else
		{
			try {
				String message = "No Student Records to Sort!!Please add the Records";
				throw new StudentNotFoundException(message);
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		}

	}
	@Override
	public void getStudentWithHighestMarks()
	{
		if(map.size()>=2)
		{
			List<Student> list = new ArrayList<Student>();
			Set<String>keys =  map.keySet();
			for(String key:keys)
			{
				Student std= map.get(key);
				list.add(std);  
			}
			Collections.sort(list, new SortStudentByMarks());
			System.out.println("Student With Highest Marks:");
			System.out.println(list.get(list.size()-1));
		}
		else
		{
			try {
				String message="No Student Records to Sort!!Please add the Records";
				throw new StudentNotFoundException(message);
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());	
			}
		}

	}
	@Override
	public void getStudentWithLowestMarks()
	{
		if(map.size()>=2)
		{
			List<Student> list = new ArrayList<Student>();
			Set<String>keys =  map.keySet();
			for(String key:keys)
			{
				Student std= map.get(key);
				list.add(std);  
			}
			Collections.sort(list, new SortStudentByMarks());
			System.out.println("Student With Highest Marks:");
			System.out.println(list.get(0));
		}
		else
		{
			try {
				String message="No Student Records to Sort!!Please add the Records";
				throw new StudentNotFoundException(message);
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());	
			}
		}

	}	

}
