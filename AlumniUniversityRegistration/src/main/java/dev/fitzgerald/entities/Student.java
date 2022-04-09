package dev.fitzgerald.entities;

public class Student {

    private int studentID;
    private String studentName;
    private String studentRegPeriod;

    public Student(int studentID, String studentName, String studentRegPeriod) {
        this.studentID = studentID;
        this.studentName = studentName;
        this.studentRegPeriod = studentRegPeriod;
    }

    public int getStudentID() {
        return studentID;
    }
    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public String getStudentName() {
        return studentName;
    }
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentRegPeriod() {
        return studentRegPeriod;
    }
    public void setStudentRegPeriod(String studentRegPeriod) {
        this.studentRegPeriod = studentRegPeriod;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentID='" + studentID + '\'' +
                ", studentName='" + studentName + '\'' +
                ", studentRegPeriod='" + studentRegPeriod + '\'' +
                '}';
    }
}
