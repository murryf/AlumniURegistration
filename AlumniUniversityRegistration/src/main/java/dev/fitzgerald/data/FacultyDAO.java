package dev.fitzgerald.data;

import dev.fitzgerald.entities.ClassOffering;
import dev.fitzgerald.entities.Faculty;

public interface FacultyDAO {

    Faculty newProfessor(Faculty newFaculty);

    //Professors can update offerings
    boolean updateClassOffering(ClassOffering offering);

    //professors can delete offerings
    boolean deleteClassOfferingID(int id);

}
