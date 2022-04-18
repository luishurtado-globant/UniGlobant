package model.student;

public class Student {

    private String studentName;
    private int age;
    private String id;

    public String getStudentName() {
        return studentName;
    }

    public String getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    public Student(String studentName, int age, String id) {
        this.id = id;
        this.studentName = studentName;
        this.age = age;
    }

}
