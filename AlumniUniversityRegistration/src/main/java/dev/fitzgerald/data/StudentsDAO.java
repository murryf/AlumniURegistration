package dev.fitzgerald.data;

import dev.fitzgerald.entities.ClassOffering;
import dev.fitzgerald.entities.Student;

public interface StudentsDAO {

    Student createStudent(Student student);

    boolean registerClass(Student student, ClassOffering offering);
    boolean dropClass(Student student, ClassOffering offering);

}
