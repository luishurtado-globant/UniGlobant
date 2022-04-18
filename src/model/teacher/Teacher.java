package model.teacher;

public abstract class Teacher {
    private String teacherName;
    private double baseSalary;
    private String contractType;

    public Teacher(String teacherName, double baseSalary, String contractType){
        this.baseSalary = baseSalary;
        this.teacherName = teacherName;
        this.contractType = contractType;
    }

    public Teacher(String tName, String contract) {
    }

    public String getTeacherName() {
        return teacherName;
    }

    public String getContractType() {
        return contractType;
    }
}
