package dev.fitzgerald.data;

import dev.fitzgerald.entities.ClassOffering;
import dev.fitzgerald.entities.Faculty;
import dev.fitzgerald.utilities.ConnectionUtil;

import java.sql.*;

public class FacultyDAOPostgresImpl implements FacultyDAO{

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

    @Override
    public void updateClassOffering(ClassOffering offering) {
        ClassOfferingDAOPostgresImpl update = new ClassOfferingDAOPostgresImpl();
        ClassOffering offer = update.updateClassOffering(offering);

    }

    @Override
    public void deleteClassOfferingID(int id) {
        ClassOfferingDAOPostgresImpl del = new ClassOfferingDAOPostgresImpl();
        del.deleteClassOfferingID(id);
    }

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

    @Override
    public void addClassOffering(ClassOffering offer) {
        ClassOfferingDAOPostgresImpl offering = new ClassOfferingDAOPostgresImpl();
        offering.createClassOffering(offer);
    }
}
