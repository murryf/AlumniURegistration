package dev.fitzgerald.data;

import dev.fitzgerald.entities.ClassOffering;
import dev.fitzgerald.entities.Faculty;

public interface FacultyDAO {

    Faculty newProfessor(Faculty newFaculty);

    //Professors can update offerings
    void updateClassOffering(ClassOffering offering);

    //professors can delete offerings
    void deleteClassOfferingID(int id);

    boolean validateFaculty(String name, String pass);

}
