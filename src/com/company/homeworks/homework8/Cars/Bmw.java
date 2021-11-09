package com.company.homeworks.homework8.Cars;

public class Bmw extends AbstractCar {

    public Bmw(String model, int yearOfManufacture, double enginePower, String bodyType) {
        super(model, yearOfManufacture, enginePower, bodyType);
        this.brand = "BMW";
    }

    @Override
    public String toString() {
        return "Bmw{" +
                "model='" + model + '\'' +
                ", yearOfManufacture=" + yearOfManufacture +
                ", enginePower=" + enginePower +
                ", bodyType='" + bodyType + '\'' +
                '}';
    }
}
