package dev.fitzgerald.daotests;

import dev.fitzgerald.data.*;
import dev.fitzgerald.entities.ClassOffering;
import dev.fitzgerald.entities.Faculty;
import dev.fitzgerald.entities.Student;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static dev.fitzgerald.daotests.ClassesDAOTests.testOffering;

public class StudentDAOTests {

    static StudentsDAO studentDAO = new StudentsDAOPostgresImpl();
    static Student testStudent = null;
    static ClassOffering testClass = new ClassOffering(0,"Algorithms", "Edgar Allen Poe", "P3");
    static ClassOfferingDAO classDAO = new ClassOfferingDAOPostgresImpl();
    @Test
    void create_new_student(){
        Student newStudent = new Student(0,"Luke Cage", "unBr34k","P3");
        Student savedNewStudent = studentDAO.createStudent(newStudent);
        StudentDAOTests.testStudent = savedNewStudent;
        Assertions.assertNotEquals(0, savedNewStudent.getStudentID());
    }

    @Test
    void register_student(){
        testClass = classDAO.createClassOffering(testClass);
        Assertions.assertTrue(studentDAO.registerClass(testStudent, classDAO.getOfferingByID(testClass.getClassID())));

    }
    @Test
    void drop_class(){
        Assertions.assertTrue(studentDAO.dropClass(testStudent,classDAO.getOfferingByID(testClass.getClassID())));
    }

}
