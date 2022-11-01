package org.day7.exercise5.exportToJson;

public class Asset implements Data {
    private int serialNumber;
    private String owner;
    private double rating;

    public Asset(int serialNumber, String owner, double rating) {
        this.serialNumber = serialNumber;
        this.owner = owner;
        this.rating = rating;
    }

    public int getSerialNumber() {
        return serialNumber;
    }

    public String getOwner() {
        return owner;
    }

    public double getRating() {
        return rating;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
