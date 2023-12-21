package customsorting;

import java.util.Comparator;

import com.jsp.student.Student;

public class SortStudentByName implements Comparator<Student> {
	
	@Override
	public int compare(Student x,Student y)
	{
		return x.getName().compareTo(y.getName());
		
	}

}
