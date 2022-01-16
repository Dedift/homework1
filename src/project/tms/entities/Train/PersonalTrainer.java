package project.tms.entities.Train;

import project.tms.entities.Order.Order;
import project.tms.entities.Order.Subscription;
import project.tms.entities.User.Gender;
import project.tms.entities.User.User;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PersonalTrainer {

    public static final int FIRST_DAY = 1;
    private static final int SECOND_DAY = 2;
    private static final int THIRST_DAY = 3;
    private int id;
    private String firstName;
    private String lastName;
    private Gender gender;
    private Date dateOfBirth;
    private int experience;

    public PersonalTrainer(String firstName, String lastName, Gender gender, Date dateOfBirth, int experience) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.experience = experience;
    }

    public PersonalTrainer() {

    }

    public void createTrainProgram(User user, Order order) {
        List<TrainingDay> trainingProgram = new ArrayList<>();
        trainingProgram.add(new TrainingDay(FIRST_DAY, order));
        trainingProgram.add(new TrainingDay(SECOND_DAY, order));
        trainingProgram.add(new TrainingDay(THIRST_DAY, order));
        user.setTrainingProgram(trainingProgram);
        user.setSubscription(new Subscription(order, user));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PersonalTrainer that = (PersonalTrainer) o;

        if (id != that.id) return false;
        if (experience != that.experience) return false;
        if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
        if (lastName != null ? !lastName.equals(that.lastName) : that.lastName != null) return false;
        if (gender != that.gender) return false;
        return dateOfBirth != null ? dateOfBirth.equals(that.dateOfBirth) : that.dateOfBirth == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (gender != null ? gender.hashCode() : 0);
        result = 31 * result + (dateOfBirth != null ? dateOfBirth.hashCode() : 0);
        result = 31 * result + experience;
        return result;
    }

    @Override
    public String toString() {
        return "PersonalTrainer{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender=" + gender +
                ", dateOfBirth=" + dateOfBirth +
                ", experience=" + experience +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }
}
