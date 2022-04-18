package model.teacher.types;

import model.teacher.Teacher;

public class FullTimeTeacher extends Teacher {
    private int experienceYears;
    private double salary;

    public FullTimeTeacher(String teacherName, double baseSalary, int experienceYears, String contractType){
        super(teacherName, baseSalary, contractType);
        this.experienceYears = experienceYears;
        this.salary = baseSalary * experienceYears;
    }

    public int getExperienceYears() {
        return experienceYears;
    }

    public double getSalary() {
        return salary;
    }
}
