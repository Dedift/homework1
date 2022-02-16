package project.tms.daoLayer.entityLayer.Train;

import project.tms.daoLayer.entityLayer.Order.Order;
import project.tms.daoLayer.entityLayer.User.Gender;
import project.tms.daoLayer.entityLayer.User.User;

import java.util.ArrayList;
import java.util.List;

public class TrainingDay {

    public static final int COUNT_REPETITIONS_PER_SET_FOR_FAT_BURNING = 20;
    public static final int COUNT_SETS_FOR_FAT_BURNING = 5;
    public static final int COUNT_REPETITIONS_PER_SET_FOR_MUSCLE = 10;
    public static final int COUNT_SETS_FOR_MUSCLE = 4;
    private static final int FIRST_DAY = 1;
    private static final int SECOND_DAY = 2;
    private static final int THIRD_DAY = 3;
    private int id;
    private int countSetsPerExercise;
    private int countRepetitionsPerSet;
    private List<Exercise> exercises;
    private User user;

    public TrainingDay(int i, Order order, User user) {
        this.user = user;
        exercises = new ArrayList<>();
        selectionAndCreateDefaultDay(i, order, user);
    }

    public TrainingDay() {
        exercises = new ArrayList<>();
    }

    private void selectionAndCreateDefaultDay(int i, Order order, User user) {
        switch (user.getGender()) {
            case (Gender.MALE):
                switch (order.getPurpose()) {
                    case (Purpose.MUSCLE):
                        createDefaultMuscleDayForMan(i);
                        this.countSetsPerExercise = COUNT_SETS_FOR_MUSCLE;
                        this.countRepetitionsPerSet = COUNT_REPETITIONS_PER_SET_FOR_MUSCLE;
                        break;
                    case (Purpose.FAT_BURNING):
                        createDefaultFatBurningDayForMan(i);
                        this.countSetsPerExercise = COUNT_SETS_FOR_FAT_BURNING;
                        this.countRepetitionsPerSet = COUNT_REPETITIONS_PER_SET_FOR_FAT_BURNING;
                        break;
                }
                break;
            case (Gender.FEMALE):
                createDefaultDayForWoman(i);
                this.countSetsPerExercise = COUNT_SETS_FOR_FAT_BURNING;
                this.countRepetitionsPerSet = COUNT_REPETITIONS_PER_SET_FOR_FAT_BURNING;
                break;
        }
    }

    private void createDefaultDayForWoman(int i) {
        switch (i) {
            case FIRST_DAY:
                this.exercises.add(new Exercise(ExercisesName.CHEST_PRESS_MACHINE));
                this.exercises.add(new Exercise(ExercisesName.JUMP_ROPE));
                this.exercises.add(new Exercise(ExercisesName.GLUTE_BRIDGE));
                this.exercises.add(new Exercise(ExercisesName.CRUNCH));
                this.exercises.add(new Exercise(ExercisesName.DONKEY_KICK));
                this.exercises.add(new Exercise(ExercisesName.BULGARIAN_SPLIT_SQUAT));
                this.exercises.add(new Exercise(ExercisesName.RUN));
                break;
            case SECOND_DAY:
                this.exercises.add(new Exercise(ExercisesName.SEAL_JUMPS));
                this.exercises.add(new Exercise(ExercisesName.LAT_PULLDOWN));
                this.exercises.add(new Exercise(ExercisesName.DUCK_WALKS));
                this.exercises.add(new Exercise(ExercisesName.BICYCLE_CRUNCH_SITTING));
                this.exercises.add(new Exercise(ExercisesName.CABLE_ROW));
                this.exercises.add(new Exercise(ExercisesName.SKATERS));
                this.exercises.add(new Exercise(ExercisesName.BACK_EXTENSION));
                this.exercises.add(new Exercise(ExercisesName.BIKE));
                break;
            case THIRD_DAY:
                this.exercises.add(new Exercise(ExercisesName.BOX_JUMPS));
                this.exercises.add(new Exercise(ExercisesName.REVERSE_CRUNCH));
                this.exercises.add(new Exercise(ExercisesName.BANDED_LATERAL_WALK));
                this.exercises.add(new Exercise(ExercisesName.JUMP_ROPE));
                this.exercises.add(new Exercise(ExercisesName.GLUTE_BRIDGE));
                this.exercises.add(new Exercise(ExercisesName.CRUNCH));
                this.exercises.add(new Exercise(ExercisesName.DONKEY_KICK));
                this.exercises.add(new Exercise(ExercisesName.RUN));
                break;
        }
    }

    private void createDefaultMuscleDayForMan(int i) {
        switch (i) {
            case FIRST_DAY:
                this.exercises.add(new Exercise(ExercisesName.BARBELL_BENCH_PRESS));
                this.exercises.add(new Exercise(ExercisesName.BARBELL_CURL));
                this.exercises.add(new Exercise(ExercisesName.CHEST_PRESS_MACHINE));
                this.exercises.add(new Exercise(ExercisesName.HAMMER_CURL));
                this.exercises.add(new Exercise(ExercisesName.LOW_CABLE_CROSSOVER));
                break;
            case SECOND_DAY:
                this.exercises.add(new Exercise(ExercisesName.BENT_OVER_ROW));
                this.exercises.add(new Exercise(ExercisesName.SKULLCRUSHER));
                this.exercises.add(new Exercise(ExercisesName.LAT_PULLDOWN));
                this.exercises.add(new Exercise(ExercisesName.CABLE_PUSH_DOWN));
                this.exercises.add(new Exercise(ExercisesName.BACK_EXTENSION));
                break;
            case THIRD_DAY:
                this.exercises.add(new Exercise(ExercisesName.BACK_SQUAT));
                this.exercises.add(new Exercise(ExercisesName.STANDING_DUMBBELL_PRESS));
                this.exercises.add(new Exercise(ExercisesName.MACHINE_HAMSTRING_CURL));
                this.exercises.add(new Exercise(ExercisesName.LIFTING_DUMBBELLS_IN_FRONT_OF_YOU));
                this.exercises.add(new Exercise(ExercisesName.STANDING_BARBELL_CALF_RAISE));
                break;
        }
    }

    private void createDefaultFatBurningDayForMan(int i) {
        switch (i) {
            case FIRST_DAY:
                this.exercises.add(new Exercise(ExercisesName.BARBELL_BENCH_PRESS));
                this.exercises.add(new Exercise(ExercisesName.BARBELL_CURL));
                this.exercises.add(new Exercise(ExercisesName.JUMP_ROPE));
                this.exercises.add(new Exercise(ExercisesName.CHEST_PRESS_MACHINE));
                this.exercises.add(new Exercise(ExercisesName.HAMMER_CURL));
                this.exercises.add(new Exercise(ExercisesName.MOUNTAIN_CLIMBER));
                this.exercises.add(new Exercise(ExercisesName.LOW_CABLE_CROSSOVER));
                this.exercises.add(new Exercise(ExercisesName.RUN));
                break;
            case SECOND_DAY:
                this.exercises.add(new Exercise(ExercisesName.BENT_OVER_ROW));
                this.exercises.add(new Exercise(ExercisesName.SKULLCRUSHER));
                this.exercises.add(new Exercise(ExercisesName.REVERSE_CRUNCH));
                this.exercises.add(new Exercise(ExercisesName.LAT_PULLDOWN));
                this.exercises.add(new Exercise(ExercisesName.CABLE_PUSH_DOWN));
                this.exercises.add(new Exercise(ExercisesName.SKATERS));
                this.exercises.add(new Exercise(ExercisesName.BACK_EXTENSION));
                this.exercises.add(new Exercise(ExercisesName.BIKE));
                break;
            case THIRD_DAY:
                this.exercises.add(new Exercise(ExercisesName.BACK_SQUAT));
                this.exercises.add(new Exercise(ExercisesName.STANDING_DUMBBELL_PRESS));
                this.exercises.add(new Exercise(ExercisesName.CRUNCH));
                this.exercises.add(new Exercise(ExercisesName.MACHINE_HAMSTRING_CURL));
                this.exercises.add(new Exercise(ExercisesName.LIFTING_DUMBBELLS_IN_FRONT_OF_YOU));
                this.exercises.add(new Exercise(ExercisesName.BICYCLE_CRUNCH_SITTING));
                this.exercises.add(new Exercise(ExercisesName.STANDING_BARBELL_CALF_RAISE));
                this.exercises.add(new Exercise(ExercisesName.PLANK));
                break;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TrainingDay that = (TrainingDay) o;

        if (id != that.id) return false;
        if (countSetsPerExercise != that.countSetsPerExercise) return false;
        if (countRepetitionsPerSet != that.countRepetitionsPerSet) return false;
        return exercises != null ? exercises.equals(that.exercises) : that.exercises == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + countSetsPerExercise;
        result = 31 * result + countRepetitionsPerSet;
        result = 31 * result + (exercises != null ? exercises.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "TrainingDay{" +
                "id=" + id +
                ", countSetsPerExercise=" + countSetsPerExercise +
                ", countRepetitionsPerSet=" + countRepetitionsPerSet +
                ", exercises=" + exercises +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCountSetsPerExercise() {
        return countSetsPerExercise;
    }

    public void setCountSetsPerExercise(int countSetsPerExercise) {
        this.countSetsPerExercise = countSetsPerExercise;
    }

    public int getCountRepetitionsPerSet() {
        return countRepetitionsPerSet;
    }

    public void setCountRepetitionsPerSet(int countRepetitionsPerSet) {
        this.countRepetitionsPerSet = countRepetitionsPerSet;
    }

    public List<Exercise> getExercises() {
        return exercises;
    }

    public void setExercises(List<Exercise> exercises) {
        this.exercises = exercises;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}