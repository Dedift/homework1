package project.tms.entities.User;

import project.tms.entities.Order.Subscription;
import project.tms.entities.Train.TrainingDay;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class User {

    private static final String MAX_LENGTH_MAIL = "31";
    private static final String MIN_LENGTH_MAIL = "5";
    private int id;
    private String email;
    private String password;
    private Gender gender;
    private List<TrainingDay> trainingProgram;
    private Subscription subscription;
    private UserData userData;
    private Role role = Role.USER;

    public User(String email, String password, Gender gender) {
        if (isMailingAddress(email)) {
            this.userData = new UserData(this);
            this.email = email;
            this.password = password;
            this.gender = gender;
        }
    }

    public User() {
        this.userData = new UserData(this);
    }

    public static boolean isMailingAddress(String mailingAddress) {
        if (Objects.nonNull(mailingAddress)) {
            return mailingAddress.matches("\\w{" + MIN_LENGTH_MAIL + "," + MAX_LENGTH_MAIL + "}@(mail|gmail)\\.(com|ru)");
        }
        return false;
    }

    public void goToTheGym() {
        if (this.subscription.getTimeOfAction().isAfter(LocalDate.now())) {
        } else if (this.subscription.getCountRemainingTrain() > 0) {
            this.subscription.setCountRemainingTrain(this.subscription.getCountRemainingTrain() - 1);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != user.id) return false;
        if (email != null ? !email.equals(user.email) : user.email != null) return false;
        if (password != null ? !password.equals(user.password) : user.password != null) return false;
        if (gender != null ? !gender.equals(user.gender) : user.gender != null) return false;
        if (trainingProgram != null ? !trainingProgram.equals(user.trainingProgram) : user.trainingProgram != null)
            return false;
        return subscription != null ? subscription.equals(user.subscription) : user.subscription == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (gender != null ? gender.hashCode() : 0);
        result = 31 * result + (trainingProgram != null ? trainingProgram.hashCode() : 0);
        result = 31 * result + (subscription != null ? subscription.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", gender='" + gender + '\'' +
                ", trainingProgram=" + trainingProgram +
                ", subscription=" + subscription +
                '}';
    }

    public UserData getUserData() {
        return userData;
    }

    public void setUserData(UserData userData) {
        this.userData = userData;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public List<TrainingDay> getTrainingProgram() {
        return trainingProgram;
    }

    public void setTrainingProgram(List<TrainingDay> trainingProgram) {
        this.trainingProgram = trainingProgram;
    }

    public Subscription getSubscription() {
        return subscription;
    }

    public void setSubscription(Subscription subscription) {
        this.subscription = subscription;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
