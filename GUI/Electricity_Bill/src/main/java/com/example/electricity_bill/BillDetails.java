package com.example.electricity_bill;

public class BillDetails {
    private int units;
    private String meterType;
    private double billAmount;
    private String selectedCity;

    // Constructor
    public BillDetails(int units, String meterType, double billAmount, String selectedCity) {
        this.units = units;
        this.meterType = meterType;
        this.billAmount = billAmount;
        this.selectedCity = selectedCity;
    }

    // Getters and setters
    public int getUnits() {
        return units;
    }

    public void setUnits(int units) {
        this.units = units;
    }

    public String getMeterType() {
        return meterType;
    }

    public void setMeterType(String meterType) {
        this.meterType = meterType;
    }

    public double getBillAmount() {
        return billAmount;
    }

    public void setBillAmount(double billAmount) {
        this.billAmount = billAmount;
    }

    public String getCity() {
        return selectedCity;
    }

    public void setCity(String city) {
        this.selectedCity = city;
    }
}
