package dev.fitzgerald.data;

import dev.fitzgerald.entities.ClassOffering;
import dev.fitzgerald.entities.Student;
import dev.fitzgerald.utilities.ArrayList;
import dev.fitzgerald.utilities.List;

public interface StudentsDAO {

    Student createStudent(Student student);

    boolean registerClass(Student student, ClassOffering offering);
    boolean dropClass(Student student, ClassOffering offering);

    boolean validateStudent(String name, String pass);

    Student getStudent(String name);

    ArrayList<ClassOffering> getClasses();
}
