package dev.fitzgerald.app;

import dev.fitzgerald.data.*;
import dev.fitzgerald.entities.ClassOffering;
import java.util.Scanner;

public class App {

    private boolean isValidFaculty = false;
    private boolean isValidStudent = false;
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
            System.out.println("Enter 3 to see class offerings");
            System.out.println("Enter -1 to exit");
            entry = io.nextInt();

            switch (entry) {
                case 1: {
                    runFaculty(io);
                } break;
                case 2: {
                    runStudent(io);
                } break;
                case 3: {
                  runClasses(io);
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


    }
    public static void runStudent(Scanner io){
        System.out.print("Please enter name: ");
        String unverifiedStudentName = io.next();
        System.out.print("Please enter password: ");
        String unverifiedPassword = io.next();


    }
    public static void runClasses(Scanner io){
    }

}
