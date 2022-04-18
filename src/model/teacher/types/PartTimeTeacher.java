package model.teacher.types;

import model.teacher.Teacher;

public class PartTimeTeacher extends Teacher {
    private int activeHours;
    private double salary;

    public PartTimeTeacher(String teacherName, double baseSalary, int activeHours, String contractType){
        super(teacherName, baseSalary, contractType);
        this.activeHours = activeHours;
        this.salary = baseSalary * activeHours;
    }

    public int getActiveHours() {
        return activeHours;
    }

    public double getSalary() {
        return salary;
    }
}




