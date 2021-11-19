package com.company.homeworks.homework9;

import java.util.Arrays;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(1, 3, 5, 3, 6, 5);
        System.out.println(ListUtils.listToString(integers));

        List<Person> peoples = Arrays.asList(
                new Person("Ivan", "Ivanov", 25),
                new Person("Petr", "Petrov", 17),
                new Person("Irina", "Petrova", 40),
                new Person("Sveta", "Ivanova", 22)
        );
        System.out.println(ListUtils.getOlderPerson(peoples));
    }
}
