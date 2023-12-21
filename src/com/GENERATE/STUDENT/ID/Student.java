package com.GENERATE.STUDENT.ID;

public class Student {

//	int id ;
//	   int count =101;
//	   
//	    Student()                       //nonstatic working
//	   {
//		   this.id=count;
//		   count++;
//		   
//	   }
	
	  String id;
	 static int count =101;
	  Student()                       //static working
	  {
		  this.id= "jsp"+count;
		  count++;
	  }
	
	public static void main(String[] args) {
		
	   Student s1=new Student();
	   Student s2=new Student();
	   Student s3=new Student();
	   
	   System.out.println(s1.id);
	   System.out.println(s2.id);
	   System.out.println(s3.id);
	   
	   

	}

}
