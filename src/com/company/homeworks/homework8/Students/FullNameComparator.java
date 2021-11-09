package com.company.homeworks.homework8.Students;

import java.util.Comparator;

public class FullNameComparator implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        int result = o1.getName().compareTo(o2.getName());
        return result == 0 ? o1.getSurname().compareTo(o2.getSurname()) : result;
    }
}
