package com.example.oop_final;

import java.io.Serializable;

public class Appliance implements Serializable {
    private String name;
    private boolean state;

    public Appliance(String name) {
        this.name = name;
        this.state = false;
    }

    public String getName() {
        return name;
    }

    public boolean getState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public String getStateAsString() {
        if (state) {
            return "On";
        } else {
            return "Off";
        }
    }
}
