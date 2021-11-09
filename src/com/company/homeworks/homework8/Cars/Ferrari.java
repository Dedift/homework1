package com.company.homeworks.homework8.Cars;

public class Ferrari extends AbstractCar {

    public Ferrari(String model, int yearOfManufacture, double enginePower, String bodyType) {
        super(model, yearOfManufacture, enginePower, bodyType);
        this.brand = "Ferrari";
    }

    @Override
    public String toString() {
        return "Ferrari{" +
                "model='" + model + '\'' +
                ", yearOfManufacture=" + yearOfManufacture +
                ", enginePower=" + enginePower +
                ", bodyType='" + bodyType + '\'' +
                '}';
    }
}
