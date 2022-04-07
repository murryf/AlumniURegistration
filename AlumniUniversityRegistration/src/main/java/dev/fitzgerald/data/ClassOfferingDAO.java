package dev.fitzgerald.data;

//Import my class offering class
import dev.fitzgerald.entities.ClassOffering;

public interface ClassOfferingDAO {

    //Create
    ClassOffering createClassOffering(ClassOffering offering);

    //Read
    ClassOffering getOfferingByID(int id);
    ClassOffering getOfferingByName(String name);
    ClassOffering getOfferingByProfessor(String name);

    //Update
    ClassOffering updateClassOffering(ClassOffering offering);

    //delete
    boolean deleteClassOfferingID(int id);


}
