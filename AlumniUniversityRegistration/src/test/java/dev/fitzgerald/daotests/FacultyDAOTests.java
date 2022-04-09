package dev.fitzgerald.daotests;

import dev.fitzgerald.data.ClassOfferingDAO;
import dev.fitzgerald.data.ClassOfferingDAOPostgresImpl;
import dev.fitzgerald.data.FacultyDAO;
import dev.fitzgerald.data.FacultyDAOPostgresImpl;
import dev.fitzgerald.entities.ClassOffering;
import dev.fitzgerald.entities.Faculty;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FacultyDAOTests {

    static FacultyDAO facultyDAO = new FacultyDAOPostgresImpl();
    static Faculty testProfessor = null;

    @Test
    void create_new_faculty(){
        Faculty newProfessor = new Faculty(0,"Margret Atwood", "3d1bl3");
        Faculty savedNewProfessor = facultyDAO.newProfessor(newProfessor);
        FacultyDAOTests.testProfessor = savedNewProfessor;
        Assertions.assertNotEquals(0, savedNewProfessor.getFacultyId());
    }

}
