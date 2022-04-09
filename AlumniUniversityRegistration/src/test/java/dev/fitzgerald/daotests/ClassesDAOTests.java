package dev.fitzgerald.daotests;

import dev.fitzgerald.data.ClassOfferingDAO;
import dev.fitzgerald.data.ClassOfferingDAOPostgresImpl;
import dev.fitzgerald.entities.ClassOffering;
import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)// to run tests in order

public class ClassesDAOTests {

    static ClassOfferingDAO offeringDAO = new ClassOfferingDAOPostgresImpl();
    static ClassOffering testOffering = null;

    @Test
    @Order(1)
    void create_class_offering() {
        ClassOffering offering =  new ClassOffering(5, "Python for AI", "Michael Criton","MWF", "5:00pm","2 hrs","P4");
        ClassOffering savedOffering = offeringDAO.createClassOffering(offering);
        ClassesDAOTests.testOffering = savedOffering;
        Assertions.assertNotEquals(0,savedOffering.getClassID());

    }

    @Test
    @Order(2)
    void get_class_by_id() {
        ClassOffering offering = offeringDAO.getOfferingByID(testOffering.getClassID());
        Assertions.assertEquals("Python for AI", offering.getClassName());
    }
    @Test
    @Order(3)
    void get_class_by_name() {
        ClassOffering offering = offeringDAO.getOfferingByName(testOffering.getClassName());
        Assertions.assertEquals("Python for AI", offering.getClassName());
    }
    @Test
    @Order(4)
    void get_class_by_professor() {
        ClassOffering offering = offeringDAO.getOfferingByProfessor(testOffering.getClassInstructor());
     //   System.out.println(offering);
        Assertions.assertEquals("Michael Criton", offering.getClassInstructor());
    }
    @Test
    @Order(5)
    void update_by_class_name() {
        ClassesDAOTests.testOffering.setClassName("Game Theory");
        offeringDAO.updateClassOffering(testOffering);
        ClassOffering offering = offeringDAO.getOfferingByID(testOffering.getClassID());
        Assertions.assertEquals("Game Theory", offering.getClassName());
    }

    @Test
    @Order(6)
    void update_bad_seats() {
        ClassesDAOTests.testOffering.setOpenSeats(-1);
        offeringDAO.updateClassOffering(testOffering);
        ClassOffering offering = offeringDAO.getOfferingByID(testOffering.getClassID());
        Assertions.assertEquals(0,offering.getOpenSeats());
    }
//    @Test
//    @Order(7)
//    void delete_Criton(){
//        Assertions.assertTrue(offeringDAO.deleteClassOfferingID(testOffering.getClassID()));
//
//    }
}
