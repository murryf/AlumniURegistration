package dev.fitzgerald.entities;

public class Faculty {

    private int facultyId;
    private String facultyName;
    private String facultyPassword;

    public Faculty(int facultyId, String facultyName, String facultyPassword) {
        this.facultyId = facultyId;
        this.facultyName = facultyName;
        this.facultyPassword = facultyPassword;
    }

    public int getFacultyId() {
        return facultyId;
    }

    public void setFacultyId(int facultyId) {
        this.facultyId = facultyId;
    }

    public String getFacultyName() {
        return facultyName;
    }

    public void setFacultyName(String facultyName) {
        this.facultyName = facultyName;
    }

    public String getFacultyPassword() {
        return facultyPassword;
    }

    public void setFacultyPassword(String facultyPassword) {
        this.facultyPassword = facultyPassword;
    }

    @Override
    public String toString() {
        return "Faculty{" +
                "facultyId=" + facultyId +
                ", facultyName='" + facultyName + '\'' +
                ", facultyPassword='" + facultyPassword + '\'' +
                '}';
    }
}
