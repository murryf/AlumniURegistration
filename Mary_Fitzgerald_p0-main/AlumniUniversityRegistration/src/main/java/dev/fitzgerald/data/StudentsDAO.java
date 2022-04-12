package dev.fitzgerald.data;

import dev.fitzgerald.entities.ClassOffering;
import dev.fitzgerald.entities.Student;
import dev.fitzgerald.utilities.ArrayList;
import dev.fitzgerald.utilities.List;
/**
 * Interface to support the Student objects in the AWS database
 * */
public interface StudentsDAO {

    /**
     * Method to create student object in the database
     * @param student the unsaved student object
     * @return the saved student object
     * */
    Student createStudent(Student student);

    /**
     * Method to register for a class and have the classes on a local array of names to be stored later
     * @param student the student to whom the classes will be associated
     * @param offering the class offering that the student signs up for
     * */
    boolean registerClass(Student student, ClassOffering offering);
    /**
     * Method to drop a class from the student object's reegistration on the database
     * Student registration period must match offering registration period
     * @param student the unsaved student object to have its class dropped
     * @param offering the unsaved offering to be taken out of the student registration
     * @return the indication of if the method executed correctly
     * */
    boolean dropClass(Student student, ClassOffering offering);

    /**
     * A method to validate the student user and their password
     *
     * @param name the name of the student user trying to access their account
     * @param pass the password submitted by someone trying to log in
     * @return the indication of if the student is valid and may proceed
     * */
    boolean validateStudent(String name, String pass);

    /**
     * Method to return a student object from the database by name
     *
     * @param name the name to be searched
     * @return the student object for use and manipulation
     * */
    Student getStudent(String name);

    /**
     * Method to get classes associated with a student object
     *
     * @return an arraylist full of classes
     * */
    ArrayList<ClassOffering> getClasses();
}
