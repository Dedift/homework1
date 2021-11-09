package com.company.homeworks.homework8;

import com.company.homeworks.homework8.Cars.*;
import com.company.homeworks.homework8.Students.*;
import com.company.homeworks.homework8.Text.TextEditorUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        TextEditorUtils.getCountOfIdenticalWords(new File(
                "resources" + File.separator + "homework8" + File.separator + "ILoveBooks.txt"));

        AbstractCar bmw = new Bmw("i8", 2017, 362, "coupe");
        AbstractCar bmw2 = new Bmw("i8", 2017, 362, "coupe");
        AbstractCar porsche = new Porsche("911Carrera", 2020, 385, "sportcar");
        Garage garage = new Garage();
        garage.parkCar(bmw);
        garage.parkCar(bmw2);
        System.out.println(garage.getCountIdenticalCars(bmw2));
        garage.carDeparture(bmw);
        System.out.println(bmw2);
        System.out.println(garage.getCountIdenticalCars(porsche));
        System.out.println(garage);

        System.out.println(TextEditorUtils.markLength4(TextEditorUtils.readTextFromFile(new File(
                "resources" + File.separator + "homework8" + File.separator + "ILoveBooks.txt"))));

        List<Student> students = new ArrayList<>();
        students.add(new Student("Alex", "Litovec", 14, 6.45));
        students.add(new Student("Alex", "Bednov", 14, 8.74));
        students.add(new Student("Polina", "Veslova", 20, 7.52));
        students.add(new Student("Lida", "Nilonina", 19, 8.98));
        System.out.println(StudentsUtils.getStudentWithHighestScore(students));
        Collections.sort(students, new AgeComparator());
        System.out.println(students);
        Collections.sort(students, new FullNameComparator());
        System.out.println(students);
        Collections.sort(students, new AverageGradeComparator());
        System.out.println(students);
    }
}
