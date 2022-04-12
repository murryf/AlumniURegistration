package dev.fitzgerald.data;

/**
 * Interface to support the storage of class offering objects in AWS cloud
 * */
//Import my class offering bean
import dev.fitzgerald.entities.ClassOffering;

public interface ClassOfferingDAO {

    //Create
    /**
     * Implemetations must define a class offering constructor that takes a class offering,
     * saves it in the AWS database, and returns the saved class offering for further manipulations
     *
     * @param offering the ClassOffering object to be saved
     * @return the saved ClassOffering object
     * */
    ClassOffering createClassOffering(ClassOffering offering);

    //Read
    /**
     * Get ClassOffering object from AWS hosting by unique class code.
     *
     * @param id the class code being searched and returned
     * @return The located class object
     * */
    ClassOffering getOfferingByID(int id);
    /**
     * Get ClassOffering object from AWS hosting by ClassOffering's name.
     *
     * @param name the class name being searched and returned
     * @return The located class object
     * */
    ClassOffering getOfferingByName(String name);
    /**
     * Get ClassOffering object from AWS hosting by professor name.
     *
     * @param name the professor being searched and returned
     * @return The located class object
     * */
    ClassOffering getOfferingByProfessor(String name);

    /**
     * Must implement a method to update a ClassOffering on the server
     *
     * @param offering the ClassOffering to be updated
     * @return the now saved offering
     * */
    //Update
    ClassOffering updateClassOffering(ClassOffering offering);

    //delete
    /**
     * A method to remove a ClassOffering object from the database
     *
     * @param id the unique ID number for a class offering
     * @return a boolean status of if the item had been deleted
     * */
    boolean deleteClassOfferingID(int id);


}
