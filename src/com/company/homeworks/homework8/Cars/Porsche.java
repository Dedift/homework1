package com.company.homeworks.homework8.Cars;

public class Porsche extends AbstractCar {

    public Porsche(String model, int yearOfManufacture, double enginePower, String bodyType) {
        super(model, yearOfManufacture, enginePower, bodyType);
        this.brand = "Porsche";
    }

    @Override
    public String toString() {
        return "Porsche{" +
                "model='" + model + '\'' +
                ", yearOfManufacture=" + yearOfManufacture +
                ", enginePower=" + enginePower +
                ", bodyType='" + bodyType + '\'' +
                '}';
    }
}
