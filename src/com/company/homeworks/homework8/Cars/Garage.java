package com.company.homeworks.homework8.Cars;

import java.util.HashMap;

public class Garage {

    private HashMap<AbstractCar, Integer> map = new HashMap<>();

    public void parkCar(AbstractCar anyCar) {
        if (anyCar != null) {
            map.put(anyCar, getCountIdenticalCars(anyCar) + 1);
        }
    }

    public int getCountIdenticalCars(AbstractCar anyCar) {
        if (anyCar != null && map.containsKey(anyCar)) {
            return map.get(anyCar);
        }
        return 0;
    }

    public void carDeparture(AbstractCar anyCar) {
        if (anyCar != null && map.containsKey(anyCar) && getCountIdenticalCars(anyCar) > 0) {
            map.put(anyCar, getCountIdenticalCars(anyCar) - 1);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Garage garage = (Garage) o;

        return map != null ? map.equals(garage.map) : garage.map == null;
    }

    @Override
    public int hashCode() {
        return map != null ? map.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Garage{" +
                "map=" + map +
                '}';
    }

    public HashMap<AbstractCar, Integer> getMap() {
        return map;
    }
}
