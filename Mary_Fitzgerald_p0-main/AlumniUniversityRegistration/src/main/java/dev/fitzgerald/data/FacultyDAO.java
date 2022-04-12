package dev.fitzgerald.data;

import dev.fitzgerald.entities.ClassOffering;
import dev.fitzgerald.entities.Faculty;

/**
 * Interface to define faculty object's behavior and interactions with database
 * */
public interface FacultyDAO {

    /**
     * Implementation must define a method to make a new professor
     *
     * @param newFaculty the faculty to be added to the database
     * @return the faculty now saved
     * */
    Faculty newProfessor(Faculty newFaculty);

    //Professors can update offerings
    /**
     *  Method to allow faculty to modify a classOffering object in the database
     *
     * @param offering the unsaved changes in a ClassOffering object
     * */
    void updateClassOffering(ClassOffering offering);

    //professors can delete offerings
    /**
     *  Method to allow faculty members to delete class offerings by id number
     *
     * @param id  the id of the class to be deleted
     * */
    void deleteClassOfferingID(int id);

    /**
     * Faculty are secured by password verification
     *
     * @param name the name of the faculty to be verified
     * @param pass the password of the faculty to be verified
     * @return a marker of if the faculty is validated
     * */
    boolean validateFaculty(String name, String pass);

    //professors can add new ClassOfferings
    /**
     *  Method to take a classOffering object and add it to the database
     *
     * @param offer the classOffering to be saved
     *  */
    void addClassOffering(ClassOffering offer);

}
