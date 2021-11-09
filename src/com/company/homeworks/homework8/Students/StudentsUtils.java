package com.company.homeworks.homework8.Students;

import java.util.Iterator;
import java.util.List;

public final class StudentsUtils {

    private StudentsUtils() {
        throw new UnsupportedOperationException();
    }

    public static Student getStudentWithHighestScore(List<Student> students) {
        if (students != null) {
            Iterator<Student> iterator = students.iterator();
            double highestScore = 0;
            Student studentWithHighestScore = null;
            while (iterator.hasNext()) {
                Student anotherStudent = iterator.next();
                if (anotherStudent.getAverageGrade() > highestScore) {
                    studentWithHighestScore = anotherStudent;
                }
                highestScore = anotherStudent.getAverageGrade();
            }
            return studentWithHighestScore;
        }
        return null;
    }
}
