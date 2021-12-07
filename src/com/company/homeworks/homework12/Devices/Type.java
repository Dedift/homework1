package com.company.homeworks.homework12.Devices;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Type {

    private boolean peripheral;
    private boolean presenceOfCooler;
    private int energyConsumption;

    @JsonCreator
    public Type(
            @JsonProperty("peripheral")boolean peripheral,
            @JsonProperty("presenceOfCooler")boolean presenceOfCooler,
            @JsonProperty("energyConsumption")int energyConsumption) {
        this.peripheral = peripheral;
        this.presenceOfCooler = presenceOfCooler;
        this.energyConsumption = energyConsumption;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Type type = (Type) o;

        if (peripheral != type.peripheral) return false;
        if (presenceOfCooler != type.presenceOfCooler) return false;
        return energyConsumption == type.energyConsumption;
    }

    @Override
    public int hashCode() {
        int result = (peripheral ? 1 : 0);
        result = 31 * result + (presenceOfCooler ? 1 : 0);
        result = 31 * result + energyConsumption;
        return result;
    }

    @Override
    public String toString() {
        return "Type{" +
                "peripheral=" + peripheral +
                ", presenceOfCooler=" + presenceOfCooler +
                ", energyConsumption=" + energyConsumption +
                '}';
    }

    public boolean isPeripheral() {
        return peripheral;
    }

    public void setPeripheral(boolean peripheral) {
        this.peripheral = peripheral;
    }

    public boolean isPresenceOfCooler() {
        return presenceOfCooler;
    }

    public void setPresenceOfCooler(boolean presenceOfCooler) {
        this.presenceOfCooler = presenceOfCooler;
    }

    public int getEnergyConsumption() {
        return energyConsumption;
    }

    public void setEnergyConsumption(int energyConsumption) {
        this.energyConsumption = energyConsumption;
    }
}
