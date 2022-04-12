package dev.fitzgerald.data;

import dev.fitzgerald.entities.ClassOffering;
import dev.fitzgerald.utilities.ConnectionUtil;

import java.sql.*;

/**
 *  A class to implement the classOfferingDAO
 *  Will be responsible for connecting to the AWS database
 * */
public class ClassOfferingDAOPostgresImpl implements ClassOfferingDAO {

    /**
     * Method to create a class offering in the AWS database in the classes table
     *
     * @param offering A ClassOffering object to be inserted into the database
     * @return the now saved class offering
     * */
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
            int generatedId = rs.getInt("class_id"); //return the value of the class_id
            offering.setClassID(generatedId); //to be saved in the offering object
            return offering;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Method to get an offering by its unique ID code
     *
     * @param id the unique id to a given class offering object
     * @return the class offering that matches the id input
     * */
    @Override
    public ClassOffering getOfferingByID(int id) {
        try {
            Connection conn = ConnectionUtil.createConnection();
            String sql = "select * from classes where class_id = ?";  //get all instances
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,id);    //specify the id

            ResultSet rs = ps.executeQuery(); //pass to a result set for construction of new classOffering object
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

    /**
     * Get an offering by searching the name
     *
     * @param name the name of the ClassOffering sought in the database
     * @return a classOffering object with the searched name
     * */
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

    /**
     *  Method to get the first class object offered under a given professor
     * @param prof The professor being searched
     * @return the first classOffering object returned from the database
     * */
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

    /**
     *  Method to update a class offering and return the updated offering
     * @param offering the unsaved ClassOffering
     * @return  the saved offering
     * */
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

    /**
     * Method to delete a class offering entry by id number
     *
     * @param id the id of the classOffering being deleted
     * @return the boolean value of if the classOffering is deleted
     * */
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
