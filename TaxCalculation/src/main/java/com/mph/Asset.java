package com.mph;

public class Asset implements Taxable {

    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public double calculateTax() {
        return 0;
    }
}
