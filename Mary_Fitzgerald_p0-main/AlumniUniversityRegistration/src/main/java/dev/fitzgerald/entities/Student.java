package dev.fitzgerald.entities;

/**
 * Class to outline a student object
 * */
public class Student {

    //Fields
    private int studentID;
    private String studentName;
    private String studentRegPeriod;
    private String passWord;
    protected String[] classes = {null,null,null};

    /**
     * Constructor for the student object
     * @param studentID the unique ID of the student object
     * @param studentName the name of the student
     * @param passWord the password for the student
     * @param studentRegPeriod the registration period for the student
     * */
    public Student(int studentID, String studentName,String passWord, String studentRegPeriod) {
        this.studentID = studentID;
        this.studentName = studentName;
        this.passWord = passWord;
        this.studentRegPeriod = studentRegPeriod;
    }

    /**
     * Method to return the student ID number
     * @return the student ID number
     * */
    public int getStudentID() {
        return studentID;
    }
    /**
     * Method to set student ID number
     * @param studentID the new ID number for the student
     * */
    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    /**
     * Method to get the student name
     * @return the name
     * */
    public String getStudentName() {
        return studentName;
    }
    /**
     * Method to set the student object's name
     * @param studentName the new name of the student object
     * */
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    /**
     * Method to get the student's registration period
     * @return the registration period
     * */
    public String getStudentRegPeriod() {
        return studentRegPeriod;
    }
    /**
     * Method to set the student object's registration period
     * @param studentRegPeriod the new registration period
     * */
    public void setStudentRegPeriod(String studentRegPeriod) {
        this.studentRegPeriod = studentRegPeriod;
    }

    /**
     * Method to retrieve a saved password from the AWS database
     * @return the string of the password
     * */
    public String getPassWord() {return passWord;}
    /**
     * Method to set the password for a student object
     * @param passWord the new password
     * */
    public void setPassWord(String passWord) {this.passWord = passWord;}

    /**
     * Method to get the classes that a student is registered for
     * @return the array of class names
     * */
    public String[] getClasses() {
        return classes;
    }

    /**
     * Method to set the class array that denotes the registered classes for a student object
     * @param classes the array of classes to be saved
     * */
    public void setClasses(String[] classes) {
        this.classes = classes;
    }

    /**
     * Method to get the string representation of the student object
     * @return the string description of the object
     * */
    @Override
    public String toString() {
        return "Student{" +
                "studentID=" + studentID +
                ", studentName='" + studentName + '\'' +
                ", studentRegPeriod='" + studentRegPeriod + '\'' +
                ", passWord='" + passWord + '\'' +
                '}';
    }
}
