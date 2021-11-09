package com.company.homeworks.homework8.Cars;

public abstract class AbstractCar {

    protected String brand;
    protected String model;
    protected int yearOfManufacture;
    protected double enginePower;
    protected String bodyType;

    protected AbstractCar(String model, int yearOfManufacture, double enginePower, String bodyType) {
        if (yearOfManufacture > 1884 && enginePower > 0) {
            this.model = model;
            this.yearOfManufacture = yearOfManufacture;
            this.enginePower = enginePower;
            this.bodyType = bodyType;
        } else throw new IllegalArgumentException();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AbstractCar that = (AbstractCar) o;

        if (yearOfManufacture != that.yearOfManufacture) return false;
        if (Double.compare(that.enginePower, enginePower) != 0) return false;
        if (!brand.equals(that.brand)) return false;
        if (model != null ? !model.equals(that.model) : that.model != null) return false;
        return bodyType != null ? bodyType.equals(that.bodyType) : that.bodyType == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = brand.hashCode();
        result = 31 * result + (model != null ? model.hashCode() : 0);
        result = 31 * result + yearOfManufacture;
        temp = Double.doubleToLongBits(enginePower);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (bodyType != null ? bodyType.hashCode() : 0);
        return result;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        if (model != null) {
            this.model = model;
        }
    }

    public int getYearOfManufacture() {
        return yearOfManufacture;
    }

    public void setYearOfManufacture(int yearOfManufacture) {
        if (yearOfManufacture > 1884) {
            this.yearOfManufacture = yearOfManufacture;
        }
    }

    public double getEnginePower() {
        return enginePower;
    }

    public void setEnginePower(double enginePower) {
        if (enginePower > 0) {
            this.enginePower = enginePower;
        }
    }

    public String getBodyType() {
        return bodyType;
    }

    public void setBodyType(String bodyType) {
        if (bodyType != null) {
            this.bodyType = bodyType;
        }
    }
}
