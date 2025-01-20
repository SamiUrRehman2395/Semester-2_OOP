package com.example.gpa_calculator;



public class Course {
    private String courseName;
    private int creditHours;
    private int marks;
    private String grade;
    private double gpa;

    public Course(String courseName, int creditHours, int marks) {
        this.courseName = courseName;
        this.creditHours = creditHours;
        this.marks = marks;
        this.grade = calculateGrade(marks);
        this.gpa = calculateGPA(marks);
    }

    private String calculateGrade(int marks) {
        if (marks >= 90) return "A+";
        if (marks >= 80 && marks < 90) return "A";
        if (marks < 80 && marks >=75) return "B+";
        if (marks < 75 && marks >=70) return "B";
        if (marks < 70 && marks >=65) return "C+";
        if (marks <65 && marks >= 60) return "C";
        if (marks <60 && marks >=55) return "D+";
        if (marks <55 && marks >=50) return "D";


        return "F";
    }

    private double calculateGPA(int marks) {
        if (marks > 90) return 4.0;
        if (marks > 80) return 4.0;
        if (marks == 79) return 3.9;
        if (marks == 78) return 3.8;
        if (marks == 77) return 3.7;
        if (marks == 76) return 3.6;
        if (marks == 75) return 3.5;
        if (marks == 74) return 3.4;
        if (marks == 73) return 3.3;
        if (marks == 72) return 3.2;
        if (marks == 71) return 3.1;
        if (marks == 70) return 3.0;
        if (marks == 69) return 2.9;
        if (marks == 68) return 2.8;
        if (marks == 67) return 2.7;
        if (marks == 66) return 2.6;
        if (marks == 65) return 2.5;
        if (marks == 64) return 2.4;
        if (marks == 63) return 2.3;
        if (marks == 62) return 2.2;
        if (marks == 61) return 2.1;
        if (marks == 60) return 2.0;
        if (marks >= 50 && marks<60) return (marks - 50) * 0.1 + 1.0;
        return 0.0;
    }

    public String getCourseName() { return courseName; }
    public int getCreditHours() { return creditHours; }
    public int getMarks() { return marks; }
    public String getGrade() { return grade; }
    public double getGpa() { return gpa; }
}
