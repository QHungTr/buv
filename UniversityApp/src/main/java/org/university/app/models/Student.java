package org.university.app.models;

public class Student {
    private final int studentID;
    private final String name;

    public Student(int studentID, String name) {
        this.studentID = studentID;
        this.name = name;
    }

    public int getStudentID() { return studentID; }
    public String getName() { return name; }
}
