package com.company.homeworks.homework11;

public class Detail {

    public String name;
    private final String[] details = {"Head", "CPU", "RAM", "HDD", "LeftHand", "RightHand", "LeftLeg", "RightLeg"};

    public Detail() {
        int indexName = (int) (Math.random() * (details.length));
        this.name = details[indexName];
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Detail detail = (Detail) o;

        return name != null ? name.equals(detail.name) : detail.name == null;
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Details{" +
                "name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }
}
