package classroom;

import java.util.ArrayList;
import java.util.List;

public class Classroom {
    public int capacity;
    public List<Student> students;

    public Classroom(int capacity) {
        this.capacity = capacity;
        this.students = new ArrayList<>();
    }

    public int getCapacity() {
        return this.capacity;
    }

    public List<Student> getStudents() {
        return this.students;
    }

    public int getStudentCount() {
        return this.students.size();
    }

    public String registerStudent(Student student) {
        String result = "No seats in the classroom";
        if (this.students.size() < this.capacity) {
            if (this.students.contains(student)) {
                result = "Student is already in the classroom";
            } else {
                this.students.add(student);
                result = String.format("Added student %s %s", student.getFirstName(), student.getLastName());
            }
        }
        return result;
    }

    public String dismissStudent(Student student) {
        String result = "Student not found";
        if (this.students.remove(student)) {
            result = String.format("Removed student %s %s", student.getFirstName(), student.getLastName());
        }

        return result;
    }

    public String getSubjectInfo(String subject) {
        StringBuilder result = new StringBuilder();
        result.append(String.format("Subject: %s", subject)).append(System.lineSeparator());
        result.append("Students:").append(System.lineSeparator());

        int count = 0;
        for (Student student : this.students) {
            if (student.getBestSubject().equals(subject)) {
                count ++;
                result.append(String.format("%s %s", student.getFirstName(), student.getLastName()));
                result.append(System.lineSeparator());
            }
        }

        if (count > 0) {
            return result.toString().trim();
        }else {
            return "No students enrolled for the subject";
        }
    }

    public Student getStudent(String firstName, String lastName) {
        Student currentStudent = null;
        for (Student student : this.students) {
            if (student.getFirstName().equals(firstName) && student.getLastName().equals(lastName)) {
                currentStudent = student;
            }
        }

        return currentStudent;
    }

    public String getStatistics() {
        StringBuilder result = new StringBuilder();
        result.append(String.format("Classroom size: %d", this.students.size())).append(System.lineSeparator());
        for (Student student : this.students) {
            result.append("==").append(student.toString()).append(System.lineSeparator());
        }

        return result.toString().trim();
    }
}
