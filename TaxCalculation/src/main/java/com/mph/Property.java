package com.mph;

public class Property extends Asset {

    private double buildUpArea;
    private double baseValue;
    private int ageOfConstruction;
    private boolean inMainCity;

    public Property(double buildUpArea, double baseValue, int ageOfConstruction, boolean inMainCity) {
        this.buildUpArea = buildUpArea;
        this.baseValue = baseValue;
        this.ageOfConstruction = ageOfConstruction;
        this.inMainCity = inMainCity;
    }

    public Property() {}

    public double getBuildUpArea() {
        return buildUpArea;
    }

    public void setBuildUpArea(double buildUpArea) {
        this.buildUpArea = buildUpArea;
    }

    public double getBaseValue() {
        return baseValue;
    }

    public void setBaseValue(double baseValue) {
        this.baseValue = baseValue;
    }

    public int getAgeOfConstruction() {
        return ageOfConstruction;
    }

    public void setAgeOfConstruction(int ageOfConstruction) {
        this.ageOfConstruction = ageOfConstruction;
    }

    public boolean isInMainCity() {
        return inMainCity;
    }

    public void setInMainCity(boolean inMainCity) {
        this.inMainCity = inMainCity;
    }

    public double ageFactor() {
        return 1.0 + (ageOfConstruction / 10.0) * 0.1;
    }

    @Override
    public double calculateTax() {

        double base = buildUpArea * ageFactor() * baseValue;

        if (inMainCity) {
            return base + (0.5 * buildUpArea); // corrected as per requirement
        } else {
            return base;
        }
    }

    @Override
    public String toString() {
        return "Property [Area=" + buildUpArea +
                ", BaseValue=" + baseValue +
                ", Age=" + ageOfConstruction +
                ", InCity=" + inMainCity + "]";
    }
}
