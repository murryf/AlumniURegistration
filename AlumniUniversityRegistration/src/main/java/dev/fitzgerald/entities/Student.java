package dev.fitzgerald.entities;

public class Student {

    private int studentID;
    private String studentName;
    private String studentRegPeriod;
    private String passWord;
    private String[] classes = {null,null,null};

    public Student(int studentID, String studentName,String passWord, String studentRegPeriod) {
        this.studentID = studentID;
        this.studentName = studentName;
        this.passWord = passWord;
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

    public String getPassWord() {return passWord;}
    public void setPassWord(String passWord) {this.passWord = passWord;}

    public String[] getClasses() {
        return classes;
    }

    public void setClasses(String[] classes) {
        this.classes = classes;
    }

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
