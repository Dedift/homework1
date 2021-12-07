package com.company.homeworks.homework12.Devices;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Device {

    private String name;
    private String origin;
    private String price;
    private boolean critical;
    private String id;
    private Type type;

    @JsonCreator
    public Device(
            @JsonProperty("name") String name,
            @JsonProperty("origin") String origin,
            @JsonProperty("price") String price,
            @JsonProperty("critical") boolean critical,
            @JsonProperty("id") String id,
            @JsonProperty("type") Type type) {
        this.name = name;
        this.origin = origin;
        this.price = price;
        this.critical = critical;
        this.id = id;
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Device device = (Device) o;

        if (critical != device.critical) return false;
        if (name != null ? !name.equals(device.name) : device.name != null) return false;
        if (origin != null ? !origin.equals(device.origin) : device.origin != null) return false;
        if (price != null ? !price.equals(device.price) : device.price != null) return false;
        if (id != null ? !id.equals(device.id) : device.id != null) return false;
        return type != null ? type.equals(device.type) : device.type == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (origin != null ? origin.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (critical ? 1 : 0);
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Device{" +
                "name='" + name + '\'' +
                ", origin='" + origin + '\'' +
                ", price='" + price + '\'' +
                ", critical=" + critical +
                ", id='" + id + '\'' +
                ", type=" + type +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public boolean isCritical() {
        return critical;
    }

    public void setCritical(boolean critical) {
        this.critical = critical;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
