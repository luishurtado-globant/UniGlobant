package runner;

import model.course.Course;
import model.student.Student;
import model.teacher.Teacher;
import model.teacher.types.FullTimeTeacher;
import model.teacher.types.PartTimeTeacher;
import model.universityModel.University;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static University myUniversity;

    public static void main(String[] args) {
        init();
        universityMenu();
    }

    public static void init(){

        //Courses
        List<Course> myCourses = new ArrayList<>();

        Course english = new Course("English", 1);
        Course history = new Course("History", 3);
        Course math = new Course("Mathematics", 2);
        Course physics = new Course("Physics", 2);

        myCourses.add(english);
        myCourses.add(history);
        myCourses.add(math);
        myCourses.add(physics);

        //Teachers
        List<Teacher> myTeachers = new ArrayList<>();

        FullTimeTeacher jorge = new FullTimeTeacher("Jorge", 1200, 2, "Full-Time");
        FullTimeTeacher camila = new FullTimeTeacher("Camila", 1800, 5, "Full-Time");
        PartTimeTeacher gabriela = new PartTimeTeacher("Gabriela", 900, 6, "Part-Time");
        PartTimeTeacher daniel = new PartTimeTeacher("Daniel", 820, 3, "Part-Time");

        myTeachers.add(jorge);
        myTeachers.add(camila);
        myTeachers.add(gabriela);
        myTeachers.add(daniel);

        //Students
        List<Student> myStudents = new ArrayList<>();

        Student juliana = new Student("Juliana", 15, "S1" );
        Student rosa = new Student("Rosa", 17, "S2");
        Student victor = new Student("Victor", 16, "S3");
        Student german = new Student("German", 18, "S4" );
        Student mauricio = new Student("Mauricio", 16, "S5");
        Student valeria = new Student("Valeria", 18, "S6");

        //Adding students to the student list
        myStudents.add(juliana);
        myStudents.add(rosa);
        myStudents.add(victor);
        myStudents.add(german);
        myStudents.add(mauricio);
        myStudents.add(valeria);

        //Adding teacher and students to each course
        english.addTeacher(jorge);
        english.addStudent(valeria);
        english.addStudent(juliana);
        english.addStudent(rosa);

        history.addTeacher(camila);
        history.addStudent(mauricio);
        history.addStudent(victor);
        history.addStudent(rosa);

        math.addTeacher(gabriela);
        math.addStudent(valeria);
        math.addStudent(mauricio);
        math.addStudent(german);

        physics.addTeacher(daniel);
        physics.addStudent(valeria);
        physics.addStudent(juliana);
        physics.addStudent(victor);
        physics.addStudent(mauricio);

        myUniversity = new University(myStudents, myTeachers, myCourses);
    }

    public static void universityMenu(){
        Scanner menuNavigate = new Scanner(System.in);
        boolean exit = true;
        System.out.println("Welcome to the UniGlobant\n");

        while (exit){
            System.out.println("--------------------------------");
            System.out.println("1. List of Teachers");
            System.out.println("2. List of Courses");
            System.out.println("3. Add a new Student");
            System.out.println("4. Add a new Course");
            System.out.println("5. Search Student by ID");
            System.out.println("6. Exit");
            System.out.println("--------------------------------");
            int option = menuNavigate.nextInt();

            switch (option){
                case 1:
                    System.out.println("List of Teachers\n");
                    myUniversity.printTeacherList();
                    break;
                case 2:
                    System.out.println("List of courses");
                    System.out.println("Select the class with the ID provided:");
                    myUniversity.printCourseList();
                    int subMenu = menuNavigate.nextInt();
                    subMenu = subMenu - 1;
                    System.out.println("-----------------------");
                    System.out.println("Here is the information of the course: \n");
                    System.out.println("Teacher: ");
                    myUniversity.printTeacherInfo(subMenu);
                    System.out.println("-----------------------");
                    System.out.println("Students: ");
                    myUniversity.printStudentInfo(subMenu);
                    break;
                case 3:
                    System.out.println("Add a new student\n");
                    System.out.println("Enter the student name: \n");
                    String newStudentName = menuNavigate.next();
                    System.out.println("Enter the student age: \n");
                    int studentAge = menuNavigate.nextInt();
                    System.out.println("Enter the ID (the first letter should be 'S' ant then a number ");
                    String id = menuNavigate.next();
                    myUniversity.addStudent(new Student(newStudentName, studentAge, id));
                    System.out.println("Select the class where you want to add the student: \n");
                    myUniversity.printCourseList();
                    int classroomId = menuNavigate.nextInt();
                    classroomId = classroomId - 1;
                    myUniversity.pushNewStudent(new Student(newStudentName, studentAge, id), classroomId);
                    break;
                case 4:
                    System.out.println("Create a new course\n");
                    System.out.println("Enter the course name: ");
                    String newCourseName = menuNavigate.next();
                    System.out.println("Enter the intensity hours: ");
                    int newIntensityHours = menuNavigate.nextInt();
                    System.out.println("Enter the student Id to add");
                    myUniversity.printStudentList();
                    String studentToPush = menuNavigate.next();
                    System.out.println("The student has been added");
                    System.out.println("Enter the teacher you want to add");
                    myUniversity.printTeacherList();
                    String teacherToPush = menuNavigate.next();
                    System.out.println("Teacher was added");
                    myUniversity.addCourse(new Course(newCourseName, newIntensityHours),myUniversity.pushStudent(studentToPush), myUniversity.pushTeacher(teacherToPush));
                    break;
                case 5:
                    System.out.println("Search student by id");
                    String studentId = menuNavigate.next();
                    myUniversity.printCoursesEnrolledByStudentId(studentId);
                    break;
                case 6:
                    exit = false;
                    break;
                default:
                    System.out.println("Select a valid option");
                    break;
            }
        }
    }
}
