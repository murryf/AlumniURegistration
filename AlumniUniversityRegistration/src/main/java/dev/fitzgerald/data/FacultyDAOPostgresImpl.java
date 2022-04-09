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
    public boolean updateClassOffering(ClassOffering offering) {
        return false;
    }

    @Override
    public boolean deleteClassOfferingID(int id) {
        return false;
    }
}
