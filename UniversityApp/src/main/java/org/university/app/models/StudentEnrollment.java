package org.university.app.models;

public class StudentEnrollment {
    private int studentID; // Foreign key referencing Student
    private int moduleID;  // Foreign key referencing Module

    // Constructor
    public StudentEnrollment() {}

    public StudentEnrollment(int studentID, int moduleID) {
        this.studentID = studentID;
        this.moduleID = moduleID;
    }

    // Getters and Setters
    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public int getModuleID() {
        return moduleID;
    }

    public void setModuleID(int moduleID) {
        this.moduleID = moduleID;
    }

    // toString method to display enrollment info
    @Override
    public String toString() {
        return "StudentEnrollment{" +
                "studentID=" + studentID +
                ", moduleID=" + moduleID +
                '}';
    }
}
