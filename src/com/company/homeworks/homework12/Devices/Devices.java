package com.company.homeworks.homework12.Devices;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Devices {

    private List<Device> devices;

    @JsonCreator
    public Devices(@JsonProperty("devices")List<Device> devices) {
        this.devices = devices;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Devices devices1 = (Devices) o;

        return devices != null ? devices.equals(devices1.devices) : devices1.devices == null;
    }

    @Override
    public int hashCode() {
        return devices != null ? devices.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Devices{" +
                "devices=" + devices +
                '}';
    }

    public List<Device> getDevices() {
        return devices;
    }
}
