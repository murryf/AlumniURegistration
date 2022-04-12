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
    static ClassOfferingDAO classDAO = new ClassOfferingDAOPostgresImpl();


    @Test
    void create_new_faculty(){
        Faculty newProfessor = new Faculty(0,"Margret Atwood", "3d1bl3");
        Faculty savedNewProfessor = facultyDAO.newProfessor(newProfessor);
        FacultyDAOTests.testProfessor = savedNewProfessor;
        Assertions.assertNotEquals(0, savedNewProfessor.getFacultyId());
    }

    @Test
    void test_password(){
        boolean valid = facultyDAO.validateFaculty("Margret Atwood", "3d1bl3");
        Assertions.assertTrue(valid);
    }

    @Test
    void update_class() {
        ClassOffering update = classDAO.getOfferingByID(1);
        update.setRegPeriod("P1");
        classDAO.updateClassOffering(update);

    }
    @Test
    void delete_class(){
        facultyDAO.deleteClassOfferingID(2);
    }

}
