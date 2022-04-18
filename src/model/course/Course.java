package model.course;

import model.student.*;
import model.teacher.Teacher;

import java.util.ArrayList;
import java.util.List;

public class Course {

    private static int ITERATOR = 1;
    private String courseName;
    private int hourlyIntensity;
    private int assignedClassroom;
    private List<Student> studentsList;
    private List<Teacher> teacherList;


    public Course(String courseName, int hourlyIntensity) {
        this.assignedClassroom = ITERATOR++;
        this.courseName = courseName;
        this.hourlyIntensity = hourlyIntensity;
        this.studentsList = new ArrayList<>();
        this.teacherList = new ArrayList<>();
    }

    public String getCourseName() {
        return courseName;
    }

    public int getAssignedClassroom() {
        return assignedClassroom;
    }

    public List<Student> getStudentsList() {
        return studentsList;
    }

    public String studentNameList() {
        for (int i = 0; i < studentsList.size(); i++) {
            System.out.println(studentsList.get(i).getId() + " " + studentsList.get(i).getStudentName());
        }
        return " ";
    }

    public void addStudent(Student newStudent) {
        studentsList.add(newStudent);
    }

    public void addTeacher(Teacher newTeacher) {
        teacherList.add(newTeacher);
    }
}
