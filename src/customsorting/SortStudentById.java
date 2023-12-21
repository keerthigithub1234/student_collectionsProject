package customsorting;

import java.util.Comparator;

import com.jsp.student.Student;



public  class SortStudentById implements Comparator<Student>{
	
	@Override
	public int compare(Student x , Student y)
	{
		return x.getId().compareTo(y.getId());
	}
	
	

}   
// x->object to be inserted 
// y->already existing object
