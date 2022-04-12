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
    public int getClassID() {
        return classID;
    }
    public void setClassID(int classID) {
        this.classID = classID;
    }

    public String getClassName() {
        return className;
    }
    public void setClassName(String className) {
        this.className = className;
    }

    public String getClassInstructor() {
        return classInstructor;
    }
    public void setClassInstructor(String classInstructor) {
        this.classInstructor = classInstructor;
    }

    public String getRegPeriod(){return this.regPeriod;}
    public void setRegPeriod(String regPeriod){this.regPeriod=regPeriod;}

    public int getOpenSeats(){return this.openSeats;}
    public void setOpenSeats(int i) {if(i > 0){this.openSeats = i;}else {this.openSeats = 0;};}

    @Override
    public String toString() {
        return "classID = " + classID +
                ", className = '" + className + '\'' +
                ", classInstructor = '" + classInstructor + '\'' +
                ", regPeriod = '" + regPeriod + '\'' +
                ", Seats = " + openSeats + '\'';
    }
}
