package model.universityModel;

import model.course.Course;
import model.student.Student;
import model.teacher.Teacher;

import java.util.List;

public class University {
    private List<Student> studentList;
    private List<Teacher> teacherList;
    private List<Course> courseList;

    public University(List<Student> studentList, List<Teacher> teacherList, List<Course> courseList){
        this.studentList = studentList;
        this.teacherList = teacherList;
        this.courseList = courseList;
    }

    public void printTeacherList() {
        for (int i = 0; i < teacherList.size(); i++) {
            System.out.println(teacherList.get(i).getTeacherName() + " ---- " + teacherList.get(i).getContractType());
        }
    }

    public void printStudentList() {
        for (int i = 0; i < studentList.size(); i++) {
            System.out.println(studentList.get(i).getId() + " " + studentList.get(i).getStudentName());
        }
    }

    public void printCourseList() {
        for (int i = 0; i < courseList.size(); i++) {
            System.out.println("-----------------------------------------------");
            System.out.println(courseList.get(i).getCourseName() +  " - Assigned classroom: " + courseList.get(i).getAssignedClassroom());
            System.out.println("-----------------------------------------------");
        }
    }

    public void printTeacherInfo(int index) {
        System.out.println(teacherList.get(index).getTeacherName());
    }

    public void printStudentInfo(int index) {
        System.out.println(courseList.get(index).studentNameList());
    }

    public void addStudent(Student newStudent) {
        studentList.add(newStudent);
    }

    public void addCourse(Course newCourse, Student stu, Teacher teacher) {
        courseList.add(newCourse);
    }

    public Student pushStudent(String stuId) {
        for (int i = 0; i < studentList.size(); i++) {
            String stuName = studentList.get(i).getStudentName();
            int stuAge = studentList.get(i).getAge();
            return new Student(stuName, stuAge, stuId );
        }
        return null;
    }

    public Teacher pushTeacher(String teacherName) {
        for (int i = 0; i < teacherList.size(); i++) {

            String tName = teacherList.get(i).getTeacherName();
            String contract = teacherList.get(i).getContractType();

            Teacher addedTeacher = new Teacher(tName, contract) {
                @Override
                public String getTeacherName() {
                    return super.getTeacherName();
                }

                @Override
                public String getContractType() {
                    return super.getContractType();
                }
            };
        }
        return null;
    }

    public void pushNewStudent(Student newStudent, int classroom) {
        courseList.get(classroom).addStudent(newStudent);
        System.out.println("The student was succefully added! ");
    }

    public boolean verifyStudentId(String id) {
        for (int i = 0; i < studentList.size(); i++) {
            return studentList.get(i).getId().equals(id);
        }
        return false;
    }

    public void printCoursesEnrolledByStudentId(String id) {
        if (verifyStudentId(id)){
            for (int i = 0; i < courseList.size(); i++) {
                List<Student> stu = courseList.get(i).getStudentsList();
                for (int j = 0; j < stu.size(); j++) {
                    if (stu.get(j).getId().equals(id)){
                        System.out.println("The student is enrolled in " + courseList.get(i).getCourseName());
                    }
                }
            }
        }else{
            System.out.println("The student is not enrolled in any course");
        }
    }
}
