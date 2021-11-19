package com.company.homeworks.homework9;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public final class ListUtils {

    private ListUtils() {
        throw new UnsupportedOperationException();
    }

    public static Optional<String> listToString(List<Integer> integerList) {
        return integerList.stream()
                .map(String::valueOf)
                .reduce((first, second) -> first + second);
    }

    public static Optional<String> getOlderPerson(List<Person> personList) {
        return personList.stream()
                .sorted(
                        Comparator.comparing(Person::getAge).reversed()
                )
                .map(person -> person.getFirstName() + " " + person.getLastName())
                .filter(fullName -> fullName.length() < 16)
                .findFirst();
    }
}
