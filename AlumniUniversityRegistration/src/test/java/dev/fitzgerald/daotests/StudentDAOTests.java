package dev.fitzgerald.daotests;

import dev.fitzgerald.data.FacultyDAO;
import dev.fitzgerald.data.FacultyDAOPostgresImpl;
import dev.fitzgerald.data.StudentsDAO;
import dev.fitzgerald.data.StudentsDAOPostgresImpl;
import dev.fitzgerald.entities.Faculty;
import dev.fitzgerald.entities.Student;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StudentDAOTests {

    static StudentsDAO studentDAO = new StudentsDAOPostgresImpl();
    static Student testStudent = null;

    @Test
    void create_new_faculty(){
        Student newStudent = new Student(0,"Luke Cage", "P3");
        Student savedNewStudent = studentDAO.createStudent(newStudent);
        StudentDAOTests.testStudent = savedNewStudent;
        Assertions.assertNotEquals(0, savedNewStudent.getStudentID());
    }

}
