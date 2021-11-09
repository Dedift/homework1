package com.company.homeworks.homework8.Cars;

public class Mercedes extends AbstractCar {

    public Mercedes(String model, int yearOfManufacture, double enginePower, String bodyType) {
        super(model, yearOfManufacture, enginePower, bodyType);
        this.brand = "Mercedes";
    }

    @Override
    public String toString() {
        return "Mercedes{" +
                "model='" + model + '\'' +
                ", yearOfManufacture=" + yearOfManufacture +
                ", enginePower=" + enginePower +
                ", bodyType='" + bodyType + '\'' +
                '}';
    }
}
