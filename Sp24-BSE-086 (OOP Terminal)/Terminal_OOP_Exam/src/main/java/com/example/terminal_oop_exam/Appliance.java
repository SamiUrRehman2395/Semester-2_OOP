package com.example.terminal_oop_exam;

import java.io.Serializable;

public class Appliance implements Serializable {
     String name;

     String state;


    public Appliance(String name) {
        this.name = name;


    }

    public Appliance(String name, String state) {
        this.name = name;
        this.state = state;
    }

    public Appliance() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}


