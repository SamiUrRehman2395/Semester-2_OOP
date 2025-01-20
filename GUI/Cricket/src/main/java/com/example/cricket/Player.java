package com.example.cricket;

import java.io.Serializable;

public class Player implements Serializable {
    String name;
    int age;
    String role;
    String country;

    public Player(String name, int age, String role, String country) {
        this.name = name;
        this.age = age;
        this.role = role;
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
