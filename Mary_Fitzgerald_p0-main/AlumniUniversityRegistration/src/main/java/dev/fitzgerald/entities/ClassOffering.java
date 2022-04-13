package dev.fitzgerald.entities;

/***
 * Class to outline the functions of a ClassOffering bean
 */

public class ClassOffering {

    //fields
    private int classID;
    private String className;
    private String classInstructor;
    private String regPeriod;
    private int openSeats = 35;

    //default constructor
    public ClassOffering() {
    }

    //please use this constructor
    /**
     * Constructor for classOffering object
     *
     * @param classID the unique id for a class object
     * @param className the name of the class
     * @param classInstructor the faculty instructor for the class
     * @param regPeriod the registration period for the class
     * @param openSeats the open seats in the class
     * */
    public ClassOffering(int classID, String className, String classInstructor, String regPeriod, int openSeats) {
        this.classID = classID;
        this.className = className;
        this.classInstructor = classInstructor;
        this.regPeriod = regPeriod;
        this.openSeats = openSeats;
    }

    //Getters and setters grouped by order of fields
    /**
     * method to get class ID from a ClassOffering object
     * @return integer class ID
     * */
    public int getClassID() {
        return classID;
    }
    /**
     * Method to set the ClassOffering ID number
     * @param classID the new ClassOffering ID
     * */
    public void setClassID(int classID) {
        this.classID = classID;
    }

    /**
     * Method to get classObject's name
     * @return the name of the class
     * */
    public String getClassName() {
        return className;
    }
    /**
     * Method to set the ClassOffering object's name
     * @param className the new name of the class offering
     * */
    public void setClassName(String className) {
        this.className = className;
    }
    /**
     *  Method to get the name of a classObject instructor
     * @return the name of the instructor
     * */
    public String getClassInstructor() {
        return classInstructor;
    }
    /**
     * Method to set the instructor for the classOffeing object
     * @param classInstructor the new class instructor
     * */
    public void setClassInstructor(String classInstructor) {
        this.classInstructor = classInstructor;
    }

    /**
     * Method to get the Registration Period for a given object
     * @return the string value of the registration period
     * */
    public String getRegPeriod(){return this.regPeriod;}
    /**
     * Method to set the registration period of the ClassOffering object
     * @param regPeriod the new registration period
     * */
    public void setRegPeriod(String regPeriod){this.regPeriod=regPeriod;}

    /**
     * Method to get the open seats in a  classOffering object
     * @return the number of open seats
     * */
    public int getOpenSeats(){return this.openSeats;}

    /**
     * Method to set the number of open seats in a ClassOffering object
     * @param i the number of open seats
     * */
    public void setOpenSeats(int i) {if(i > 0){this.openSeats = i;}else {this.openSeats = 0;};}

    /**
     * To string method to write the parameters of a classOffering object
     * @return the string representation of a ClassOffering
     * */
    @Override
    public String toString() {
        return "classID = " + classID +
                ", className = '" + className + '\'' +
                ", classInstructor = '" + classInstructor + '\'' +
                ", regPeriod = '" + regPeriod + '\'' +
                ", Seats = " + openSeats + '\'';
    }
}
