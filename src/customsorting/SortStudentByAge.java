package customsorting;

import java.util.Comparator;

import com.jsp.student.Student;

public class SortStudentByAge implements Comparator<Student>{
	
	@Override
	public int compare(Student x,Student y)
	{
		return x.getAge()-y.getAge();
	}

}

//x->object to be inserted 
//y->already existing object
