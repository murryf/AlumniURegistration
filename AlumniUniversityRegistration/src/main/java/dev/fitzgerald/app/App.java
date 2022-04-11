package dev.fitzgerald.app;

import dev.fitzgerald.data.*;
import dev.fitzgerald.entities.ClassOffering;
import dev.fitzgerald.entities.Student;
import dev.fitzgerald.utilities.ArrayList;

import java.util.Scanner;

public class App {

    protected static boolean isValidFaculty = false;
    protected static boolean isValidStudent = false;
    public static ClassOfferingDAO classes = new ClassOfferingDAOPostgresImpl();
    public static FacultyDAO faculty = new FacultyDAOPostgresImpl();
    public static StudentsDAO student = new StudentsDAOPostgresImpl();

    public static void main(String[] args) {
        int entry = 0;

        while(entry != -1){
            Scanner io = new Scanner(System.in);
            System.out.println("Welcome to the registration portal!");
            System.out.println("Enter 1 for faculty log-in");
            System.out.println("enter 2 for student log-in");
            System.out.println("Enter -1 to exit");
            entry = io.nextInt();

            switch (entry) {
                case 1: {
                    runFaculty(io);
                } break;
                case 2: {
                    runStudent(io);
                } break;
                case -1: {
                    System.out.println("Good Bye!");
                } break;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    public static void runFaculty(Scanner io){
        System.out.print("Please enter name: ");
        String unverifiedFacultyName = io.next();
        System.out.print("Please enter password: ");
        String unverifiedPassword = io.next();
        isValidFaculty = faculty.validateFaculty(unverifiedFacultyName,unverifiedPassword);
        if(isValidFaculty) {
            System.out.println("Welcome, " + unverifiedFacultyName);
            int choice = 0;
            while(choice != -1){
                System.out.println("Please choose:");
                System.out.println("1) Modify Classes \n2) Delete Class\n3) Add class\n-1) return to main menu");
                choice = io.nextInt();

                switch (choice){
                    case 1:{
                        int id = 0;

                        System.out.println("Please enter the unmodified class id: ");
                        id = io.nextInt();
                        ClassOffering modified = new ClassOfferingDAOPostgresImpl().getOfferingByID(id);
                        System.out.println("Please enter the class name:");
                        modified.setClassName(io.next());
                        System.out.println("Please enter the faculty instructor: ");
                        modified.setClassInstructor(io.next());
                        System.out.println("Please enter the registration period: ");
                        modified.setRegPeriod(io.next());
                        System.out.println("Please enter the open seats: ");
                        modified.setOpenSeats(io.nextInt());
                        faculty.updateClassOffering(modified);
                    } break;
                    case 2: {
                        int id;
                        System.out.println("Please enter class id to be deleted: ");
                        id = io.nextInt();
                        faculty.deleteClassOfferingID(id);
                    } break;
                    case 3: {
                        ClassOffering newOffering = new ClassOffering();
                        System.out.println("Please fill out the following.\nClass name: ");
                        newOffering.setClassName(io.next());
                        System.out.println("Class Instructor: ");
                        newOffering.setClassInstructor(io.next());
                        System.out.println("Registration Period: ");
                        newOffering.setRegPeriod(io.next());
                        System.out.println("Seats: ");
                        newOffering.setOpenSeats(io.nextInt());
                        faculty.addClassOffering(newOffering);
                    } break;
                    case -1: {
                        isValidFaculty = false;
                        System.out.println("Logged out of faculty portal");
                    }break;
                    default: {
                        System.out.println("Invalid choice");
                    }
                }
            }
        }
    }
    public static void runStudent(Scanner io) {
        System.out.print("Please enter name: ");
        String unverifiedStudentName = io.next();
        System.out.print("Please enter password: ");
        String unverifiedPassword = io.next();
        isValidStudent = student.validateStudent(unverifiedStudentName, unverifiedPassword);
        if (isValidStudent) {
            int choice = 0;
            while (choice != -1) {
                System.out.println("Welcome, " + unverifiedStudentName);
                System.out.println("Please choose from the following");
                System.out.println("1) Register new student\n2) View available classes\n3) Register for class"
                        +"\n4) Drop Class\n5) View Registered classes\n-1) Log Out");
                choice = io.nextInt();
                StudentsDAO students = new StudentsDAOPostgresImpl();
                ClassOfferingDAO classes = new ClassOfferingDAOPostgresImpl();

                switch (choice){
                    case 1: {
                        Student newStudent = new Student(0,"","","");
                        System.out.println("Please enter the following:");
                        System.out.print("Student name: ");
                        newStudent.setStudentName(io.next());
                        System.out.print("Set Student password: ");
                        newStudent.setPassWord(io.next());
                        System.out.print("Set Student registration period: ");
                        newStudent.setStudentRegPeriod(io.next());
                        students.createStudent(newStudent);
                    }break;
                    case 2: {
                        ArrayList<ClassOffering> theClasses = students.getClasses();
                        for(int i = 0; i < theClasses.size(); i++){
                            System.out.println(theClasses.get(i).toString());
                        }
                    }break;
                    case 3: {
                        System.out.println("Please enter student name: ");
                        Student theStudent = students.getStudent(io.next());
                        System.out.println("Enter class number: ");
                        ClassOffering theClass = classes.getOfferingByID(io.nextInt());
                        if(student.registerClass(theStudent,theClass)){
                            System.out.println("Register successful");
                        } else {
                            System.out.println("Failed to register for class");
                        }

                    }break;
                    case 4: {
                        System.out.println("Please enter the student name: ");
                        Student theStudent = students.getStudent(io.next());
                        System.out.println("Enter class number: ");
                        ClassOffering theClass = classes.getOfferingByID(io.nextInt());
                        if(student.dropClass(theStudent, theClass)){
                            System.out.println("Dropped class successful");
                        } else {
                            System.out.println("Failed to drop class");
                        }

                    }break;
                    case 5: {

                    }break;
                    case -1: {
                        isValidStudent = false;
                        System.out.println("Logged Out");
                    }break;
                    default:{
                        System.out.println("Invalid choice");
                    }
                }
            }
        }
    }
}
