package dev.fitzgerald.data;

import dev.fitzgerald.entities.ClassOffering;
import dev.fitzgerald.utilities.ConnectionUtil;

import java.sql.*;

public class ClassOfferingDAOPostgresImpl implements ClassOfferingDAO {
    @Override
    public ClassOffering createClassOffering(ClassOffering offering) {
        try {
            Connection conn = ConnectionUtil.createConnection();
            String sql = "insert into classes values (default,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, offering.getClassName());
            ps.setString(2,offering.getClassInstructor());
            ps.setString(3,offering.getRegPeriod());
            ps.setInt(4,offering.getOpenSeats());


            ps.execute();

            ResultSet rs = ps.getGeneratedKeys(); // ResultSet a virtual table of results
            rs.next();// move to the first record of the result set
            int generatedId = rs.getInt("class_id");
            offering.setClassID(generatedId);
            return offering;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public ClassOffering getOfferingByID(int id) {
        try {
            Connection conn = ConnectionUtil.createConnection();
            String sql = "select * from classes where class_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,id);

            ResultSet rs = ps.executeQuery();
            rs.next();
            ClassOffering offering  = new ClassOffering();
            offering.setClassID(rs.getInt("class_id"));
            offering.setClassName(rs.getString("class_name"));
            offering.setClassInstructor(rs.getString("class_professor"));
            offering.setRegPeriod(rs.getString("reg_period"));
            offering.setOpenSeats(rs.getInt("open_seats"));


            return offering;

        }catch(SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public ClassOffering getOfferingByName(String name) {
        try {
            Connection conn = ConnectionUtil.createConnection();
            String sql = "select * from classes where class_name = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,name);

            ResultSet rs = ps.executeQuery();
            rs.next();
            ClassOffering offering  = new ClassOffering();
            offering.setClassID(rs.getInt("class_id"));
            offering.setClassName(rs.getString("class_name"));
            offering.setClassInstructor(rs.getString("class_professor"));
            offering.setRegPeriod(rs.getString("reg_period"));
            offering.setOpenSeats(rs.getInt("open_seats"));
            return offering;

        }catch(SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public ClassOffering getOfferingByProfessor(String prof) {
        try {
            Connection conn = ConnectionUtil.createConnection();
            String sql = "select * from classes where class_professor = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,prof);

            ResultSet rs = ps.executeQuery();
            rs.next();
            ClassOffering offering  = new ClassOffering();
            offering.setClassID(rs.getInt("class_id"));
            offering.setClassName(rs.getString("class_name"));
            offering.setClassInstructor(rs.getString("class_professor"));
            offering.setRegPeriod(rs.getString("reg_period"));
            offering.setOpenSeats(rs.getInt("open_seats"));
            return offering;

        }catch(SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public ClassOffering updateClassOffering(ClassOffering offering) {
        try {
            Connection conn = ConnectionUtil.createConnection();
            String sql = "update classes set class_name = ?, class_professor = ?, reg_period = ?, open_seats = ? where class_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, offering.getClassName());
            ps.setString(2, offering.getClassInstructor());
            ps.setString(3,offering.getRegPeriod());
            ps.setInt(4,offering.getOpenSeats());
            ps.setInt(5,offering.getClassID());
            ps.executeUpdate();
            return  offering;

        } catch (SQLException e) {
            e.printStackTrace();
            return  null;
        }

    }


    @Override
    public boolean deleteClassOfferingID(int id) {
        try {
            Connection conn = ConnectionUtil.createConnection();
            String sql = "delete from classes where class_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
            return  true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
