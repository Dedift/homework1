package project.tms.entities.Train;

import project.tms.entities.Order.Order;

import java.util.ArrayList;
import java.util.List;

public class TrainingDay {

    private int id;
    private List<Exercise> exercises;

    public TrainingDay(int i, Order order) {
        exercises = new ArrayList<>();
        if (order.getPurpose().equals(Purpose.MUSCLE)) {
            createMuscleDay(i);
        } else {
            createFatBurningDay(i);
        }
    }

    public TrainingDay() {
        exercises = new ArrayList<>();
    }

    public void createMuscleDay(int i) {
        switch (i) {
            case 1:
                this.exercises.add(Exercise.PRISED);
                this.exercises.add(Exercise.JIM);
                break;
            case 2:
                this.exercises.add(Exercise.PRISED);
                this.exercises.add(Exercise.JIM);
                break;
            case 3:
                this.exercises.add(Exercise.PRISED);
                this.exercises.add(Exercise.JIM);
                break;
        }
    }

    public void createFatBurningDay(int i) {
        switch (i) {
            case 1:
                this.exercises.add(Exercise.PRISED);
                this.exercises.add(Exercise.JIM);
                break;
            case 2:
                this.exercises.add(Exercise.PRISED);
                this.exercises.add(Exercise.JIM);
                break;
            case 3:
                this.exercises.add(Exercise.PRISED);
                this.exercises.add(Exercise.JIM);
                break;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TrainingDay that = (TrainingDay) o;

        if (id != that.id) return false;
        return exercises != null ? exercises.equals(that.exercises) : that.exercises == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (exercises != null ? exercises.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "TrainingDay{" +
                "id=" + id +
                ", exercises=" + exercises +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Exercise> getExercises() {
        return exercises;
    }

    public void setExercises(List<Exercise> exercises) {
        this.exercises = exercises;
    }
}