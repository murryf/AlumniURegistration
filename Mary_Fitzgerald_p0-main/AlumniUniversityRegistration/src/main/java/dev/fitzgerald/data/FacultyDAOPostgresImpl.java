package dev.fitzgerald.data;

import dev.fitzgerald.entities.ClassOffering;
import dev.fitzgerald.entities.Faculty;
import dev.fitzgerald.utilities.ConnectionUtil;

import java.sql.*;
/**
 * Class to implement the FacultyDAO for database access and modification
 * */
public class FacultyDAOPostgresImpl implements FacultyDAO{


    /**
     *  method to add a new professor to the database
     *
     * @param newFaculty the unsaved faculty object to be saved
     * @return the newly saved faculty object
     * */
    @Override
    public Faculty newProfessor(Faculty newFaculty) {
        try {
            Connection conn = ConnectionUtil.createConnection();
            String sql = "insert into faculty values (default,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, newFaculty.getFacultyName());
            ps.setString(2,newFaculty.getFacultyPassword());

            ps.execute();

            ResultSet rs = ps.getGeneratedKeys(); // ResultSet a virtual table of results
            rs.next();// move to the first record of the result set
            int generatedId = rs.getInt("faculty_id");
            newFaculty.setFacultyId(generatedId);
            return newFaculty;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Method to update a class offering in the database
     *
     * @param offering the unsaved updated classOffering object
     * */
    @Override
    public void updateClassOffering(ClassOffering offering) {
        ClassOfferingDAOPostgresImpl update = new ClassOfferingDAOPostgresImpl(); //call other DAOimpl
        ClassOffering offer = update.updateClassOffering(offering); //run update
    }
    /**
     *  Method to delete a classOffering object based on id
     *
     * @param id is the id to be searched
     * */
    @Override
    public void deleteClassOfferingID(int id) {
        ClassOfferingDAOPostgresImpl del = new ClassOfferingDAOPostgresImpl();
        del.deleteClassOfferingID(id);
    }

    /**
     * Method to validate password of a given faculty member
     * @param name  the name of the professor being validated
     * @param pass the submitted password for the given faculty name
     * @return an indicator of the faculty being valid
     * */
    public boolean validateFaculty(String name, String pass){
        try {
            Connection conn = ConnectionUtil.createConnection();
            String sql = "select faculty_password from faculty where faculty_name = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();

            rs.next();// move to the first record of the result set

            if(rs.getString(1).equals(pass)){
                return true;
            }
            System.out.println("Failed to validate faculty member");
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Method to add a new ClassOffering object to the AWS database
     *
     * @param offer the unsaved ClassOffering object to be saved
     * */
    @Override
    public void addClassOffering(ClassOffering offer) {
        ClassOfferingDAOPostgresImpl offering = new ClassOfferingDAOPostgresImpl();
        offering.createClassOffering(offer);
    }
}
