package com.example.fitness_centre;


import javafx.beans.property.SimpleStringProperty;
public  class Member {
    private final String name;
    private final String gender;
    private final String dob;
    private final String membershipType;

    public Member(String name, String gender, String dob, String membershipType) {
        this.name = name;
        this.gender = gender;
        this.dob = dob;
        this.membershipType = membershipType;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public String getDob() {
        return dob;
    }

    public String getMembershipType() {
        return membershipType;
    }
}
