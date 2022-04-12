package dev.fitzgerald.data;

import dev.fitzgerald.entities.ClassOffering;
import dev.fitzgerald.entities.Student;
import dev.fitzgerald.utilities.ArrayList;
import dev.fitzgerald.utilities.ConnectionUtil;

import java.sql.*;

public class StudentsDAOPostgresImpl implements StudentsDAO{

    /**
     * Method to create a student object in the database
     *
     * @param student the unsaved student object to be entered into the database
     * @return the student object, now saved
     * */
    @Override
    public Student createStudent(Student student) {
        try {
            Connection conn = ConnectionUtil.createConnection();
            String sql = "insert into students values (default,?,?,?,null,null,null)";
            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, student.getStudentName());
            ps.setString(2,student.getPassWord());
            ps.setString(3,student.getStudentRegPeriod());

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

    /**
     * Method to validate student identity and access
     *
     * @param name the name of the student
     * @param pass the password of the student
     * @return the indicator of if a student is valid
     * */
    public boolean validateStudent(String name, String pass){
        try {
            Connection conn = ConnectionUtil.createConnection();
            String sql = "select stdnt_pass from students where student_name = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();

            rs.next();// move to the first record of the result set

            if(rs.getString(1).equals(pass)){
                return true;
            }
            System.out.println("Failed to validate student");
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }
    /**
     * The method to return a student from the database by searching their name
     *
     * @param name the name of the student to be searched
     * @return the student object from the database
     * */
    @Override
    public Student getStudent(String name) {
        try {
            Student currentStudent = new Student(0,"","","");
            Connection conn = ConnectionUtil.createConnection();
            String sql = "select * from students where student_name = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();
            rs.next();// move to the first record of the result set
            currentStudent.setStudentID(rs.getInt("student_id"));
            currentStudent.setStudentName(rs.getString("student_name"));
            currentStudent.setPassWord(rs.getString("Stdnt_pass"));
            currentStudent.setStudentRegPeriod(rs.getString("stu_reg_period"));
            return currentStudent;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Could not connect to database");
            return null;
        }
    }

    /**
     * Method to get all classes associated with a student log in session
     *
     * @return the arraylist of classOffering objects
     * */
    @Override
    public ArrayList<ClassOffering> getClasses() {
        try {
            Connection conn = ConnectionUtil.createConnection();
            String sql = "select * from classes";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            ArrayList<ClassOffering> classes = new ArrayList();
            while (rs.next()){
                ClassOffering offering = new ClassOffering();
                offering.setClassID(rs.getInt("class_id"));
                offering.setClassName(rs.getString("class_name"));
                offering.setClassInstructor(rs.getString("class_professor"));
                offering.setRegPeriod(rs.getString("reg_period"));
                offering.setOpenSeats(rs.getInt("open_seats"));
                classes.add(offering);
            }

            return classes;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Method to register a student object for a class object and place it in the associated
     * instance of log in. Classes must be manually saved to store in the database
     *
     * @param student the student to be registered
     * @param offering the classOffering to be registered
     * @return the indicator of if the registration executed without trouble
     * */
    @Override
    public boolean registerClass(Student student, ClassOffering offering) {
        if(student.getStudentRegPeriod().equals(offering.getRegPeriod())) {
            offering.setOpenSeats(offering.getOpenSeats()-1);
            ClassOfferingDAOPostgresImpl update = new ClassOfferingDAOPostgresImpl();
            update.updateClassOffering(offering);
            String[] work = new String[3];

            for(int i = 0; i < 3; i++){
                if(student.getClasses()[i] == null){
                    work[i] = offering.getClassName();
                    i = 3;
                }
            }
            student.setClasses(work);
            return true;
        }
        return false;
    }

    /**
     * Method to save the class list associated with the log in instance
     *
     * @param student the student with the associated class list to be saved
     * @return the indicator that the save method executed without exceptions
     * */
    public boolean saveClasses(Student student){
        try {
            Connection conn = ConnectionUtil.createConnection();
            String sql = "update students set stu_class_1 = ?,stu_class_2 = ?, stu_class_3 = ? where student_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, student.getClasses()[0]);
            ps.setString(2, student.getClasses()[1]);
            ps.setString(3, student.getClasses()[2]);
            ps.setInt(4,student.getStudentID());
            ps.executeUpdate();

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Method to drop a class from the student list of classes assuming the registration
     * periods are identical.
     *
     * @param student the student to drop the class
     * @param offering the class being dropped
     * @return the indicator of complete execution.
     * */
    @Override
    public boolean dropClass(Student student, ClassOffering offering) {
        if(student.getStudentRegPeriod().equals(offering.getRegPeriod())){

            ClassOfferingDAOPostgresImpl update = new ClassOfferingDAOPostgresImpl();
            offering.setOpenSeats(offering.getOpenSeats()+1);
            update.updateClassOffering(offering);

            String[] work = new String[3];

            for(int i = 0; i < 3; i++){
                if(offering.getClassName() == student.getClasses()[i]){
                } else {
                    work[i] = student.getClasses()[i];
                }
            }
            student.setClasses(work);
            try {
                Connection conn = ConnectionUtil.createConnection();
                String sql = "update students set stu_class_1 = ?,stu_class_2 = ?, stu_class_3 = ? where student_id = ?";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, student.getClasses()[0]);
                ps.setString(2, student.getClasses()[1]);
                ps.setString(3, student.getClasses()[2]);
                ps.setInt(4,student.getStudentID());
                ps.executeUpdate();

                System.out.println("Class dropped");
                return true;
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        }
        System.out.println("Failed to drop class");
        return false;
    }
}