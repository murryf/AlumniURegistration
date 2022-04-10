package dev.fitzgerald.app;

import java.awt.*;
import java.util.Scanner;

public class App {

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
                    runFaculty();
                } break;
                case 2: {
                    runStudent();
                } break;
                case 3: {
                  runClasses();
                } break;
                case -1: {
                    System.out.println("Good Bye!");
                } break;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    public static void runFaculty(){

    }
    public static void runStudent(){

    }
    public static void runClasses(){

    }

}
