package dev.fitzgerald.entities;
/**
 * Class to define the basic interactions with a faculty member object
 * */

public class Faculty {

    //fields
    private int facultyId;
    private String facultyName;
    private String facultyPassword;

    /**
     * Constructor for faculty object
     * @param facultyId the unique faculty ID for the faculty object
     * @param facultyName the faculty member's username for the object
     * @param facultyPassword the faculty member's password
     * */
    public Faculty(int facultyId, String facultyName, String facultyPassword) {
        this.facultyId = facultyId;
        this.facultyName = facultyName;
        this.facultyPassword = facultyPassword;
    }
    /**
     * Method to return the faculty object's unique ID
     * @return the ID number
     * */
    public int getFacultyId() {
        return facultyId;
    }

    /**
     * Method to set the faculty ID for a given object
     * @param facultyId the new ID code for the faculty object
     * */
    public void setFacultyId(int facultyId) {
        this.facultyId = facultyId;
    }

    /**
     * Method to get and return faculty member's name
     * @return the string of their name
     * */
    public String getFacultyName() {
        return facultyName;
    }

    /**
     * Method to set faculty member's name
     * @param facultyName the new name of the faculty member object
     * */
    public void setFacultyName(String facultyName) {
        this.facultyName = facultyName;
    }

    /**
     * Method to get the password of the faculty member for comparison and validation
     * @return the string of the password
     * */
    public String getFacultyPassword() {
        return facultyPassword;
    }

    /**
     * Method to set the faculty member's password
     * @param facultyPassword the new password
     * */
    public void setFacultyPassword(String facultyPassword) {
        this.facultyPassword = facultyPassword;
    }

    /**
     * To String method to represent the Faculty object as a string
     * @return the string representing the faculty object
     * */
    @Override
    public String toString() {
        return "Faculty{" +
                "facultyId=" + facultyId +
                ", facultyName='" + facultyName + '\'' +
                ", facultyPassword='" + facultyPassword + '\'' +
                '}';
    }
}
