package project.tms.daoLayer.entityLayer.Train;

import project.tms.daoLayer.entityLayer.Order.Order;
import project.tms.daoLayer.entityLayer.Order.Subscription;
import project.tms.daoLayer.entityLayer.User.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PersonalTrainer {

    public static final int FIRST_DAY = 1;
    private static final int SECOND_DAY = 2;
    private static final int THIRD_DAY = 3;
    private int id;
    private String firstName;
    private String lastName;
    private String gender;
    private LocalDate dateOfBirth;
    private int experience;
    private List<User> wards;

    public PersonalTrainer(String firstName, String lastName, String gender, LocalDate dateOfBirth, int experience) {
        this.wards = new ArrayList<>();
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.experience = experience;
    }

    public PersonalTrainer() {
        this.wards = new ArrayList<>();
    }

    public void createTrainProgram(User user, Order order) {
        List<TrainingDay> trainingProgram = new ArrayList<>();
        trainingProgram.add(new TrainingDay(FIRST_DAY, order, user));
        trainingProgram.add(new TrainingDay(SECOND_DAY, order, user));
        trainingProgram.add(new TrainingDay(THIRD_DAY, order, user));
        user.setTrainingProgram(trainingProgram);
        new Subscription(order, user);
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
        if (gender != null ? !gender.equals(that.gender) : that.gender != null) return false;
        if (dateOfBirth != null ? !dateOfBirth.equals(that.dateOfBirth) : that.dateOfBirth != null) return false;
        return wards != null ? wards.equals(that.wards) : that.wards == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (gender != null ? gender.hashCode() : 0);
        result = 31 * result + (dateOfBirth != null ? dateOfBirth.hashCode() : 0);
        result = 31 * result + experience;
        result = 31 * result + (wards != null ? wards.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "PersonalTrainer{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender='" + gender + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", experience=" + experience +
                ", wards=" + wards +
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public List<User> getWards() {
        return wards;
    }

    public void setWards(List<User> wards) {
        this.wards = wards;
    }
}
