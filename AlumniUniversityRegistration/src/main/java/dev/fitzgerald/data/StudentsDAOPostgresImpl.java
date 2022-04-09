package dev.fitzgerald.data;

import dev.fitzgerald.entities.ClassOffering;
import dev.fitzgerald.entities.Student;
import dev.fitzgerald.utilities.ConnectionUtil;

import java.sql.*;

public class StudentsDAOPostgresImpl implements StudentsDAO{

    @Override
    public Student createStudent(Student student) {
        try {
            Connection conn = ConnectionUtil.createConnection();
            String sql = "insert into students values (default,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, student.getStudentName());
            ps.setString(2,student.getStudentRegPeriod());

            ps.execute();

            ResultSet rs = ps.getGeneratedKeys(); // ResultSet a virtual table of results
            rs.next();// move to the first record of the result set
            int generatedId = rs.getInt("student_id");
            student.setStudentID(generatedId);
            return student;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean registerClass(Student student, ClassOffering offering) {
        return false;
    }

    @Override
    public boolean dropClass(Student student, ClassOffering offering) {
        return false;
    }
}
