package classroom;

import java.util.List;

public class Main {
	public static void main(String[] args){

		Classroom classroom = new Classroom(4);

		Student student = new Student("Peter", "Parker", "Geometry");
		Student studentTwo = new Student("Sarah", "Smith", "Algebra");
		Student studentThree = new Student("Sam", "Winchester", "Algebra");
		Student studentFour = new Student("Dean", "Winchester", "Music");
		Student studentFive = new Student("Ellie", "Goulding", "Music");

		System.out.println(student);
		System.out.println(studentTwo);
		System.out.println(studentThree);
		System.out.println(studentFour);
		System.out.println(studentFive);

		String register = classroom.registerStudent(student);
		String register1 = classroom.registerStudent(studentTwo);
		String register2 = classroom.registerStudent(studentThree);
		String register3 = classroom.registerStudent(studentFour);
		String register4 = classroom.registerStudent(studentFive);

		System.out.println(register);
		System.out.println(register1);
		System.out.println(register2);
		System.out.println(register3);
		System.out.println(register4);

		System.out.println(student);

		System.out.println(classroom.getCapacity());

		List<Student> temp = classroom.getStudents();

		for (Student studentt : temp) {
			System.out.println(studentt);
		}

		System.out.println(classroom.getStudentCount());

		String dismissed = classroom.dismissStudent(student);
		System.out.println(dismissed); // Removed student Peter Parker
		String dismissedTwo = classroom.dismissStudent(studentFive);
		System.out.println(dismissedTwo); // Student not found

		String subjectInfo = classroom.getSubjectInfo("Algebra");
		System.out.println(subjectInfo);

		String subjectInfo2 = classroom.getSubjectInfo("Cinema");
		System.out.println(subjectInfo2);

		System.out.println(classroom.getStatistics());

		Student test = classroom.getStudent("Sarah", "Smith");

		System.out.println(test);
	}
}
