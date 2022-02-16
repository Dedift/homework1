package project.tms.daoLayer.entityLayer.Order;

import project.tms.daoLayer.entityLayer.User.User;

import java.time.LocalDate;
import java.util.Objects;

public class Subscription {

    private static final int ZERO = 0;
    private int id;
    private LocalDate timeOfAction;
    private int countRemainingTrain;
    private User user;

    public Subscription(Order order, User user) {
        if (Objects.nonNull(order) && Objects.nonNull(user)) {
            this.user = user;
            createSubscription(order, user);
        }
    }

    public Subscription() {}

    private void createSubscription(Order order, User user) {
        if (order.getCountTrain() > ZERO) {
            this.countRemainingTrain = mathCountRemainingTrain(order, user);
        } else {
            this.timeOfAction = mathTimeOfAction(order, user);
        }
        user.setSubscription(this);
    }

    private int mathCountRemainingTrain(Order order, User user) {
        int result = -1;
        if (Objects.nonNull(user.getSubscription())) {
            result = user.getSubscription().getCountRemainingTrain() + order.getCountTrain();
        } else {
            result = order.getCountTrain();
        }
        return result;
    }

    private LocalDate mathTimeOfAction(Order order, User user) {
        LocalDate date = LocalDate.now();
        if (Objects.nonNull(user.getSubscription().getTimeOfAction()) &&
                user.getSubscription().getTimeOfAction().isAfter(LocalDate.now())) {
            date = user.getSubscription().getTimeOfAction();
        }
            String season = order.getSeason();
        return switch (season) {
            case Season.MONTH -> date.plusMonths(1);
            case Season.SIX_MONTHS -> date.plusMonths(6);
            case Season.YEAR -> date.plusYears(1);
            default -> date;
        };
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Subscription that = (Subscription) o;

        if (id != that.id) return false;
        if (countRemainingTrain != that.countRemainingTrain) return false;
        if (timeOfAction != null ? !timeOfAction.equals(that.timeOfAction) : that.timeOfAction != null)
            return false;
        return user != null ? user.equals(that.user) : that.user == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (timeOfAction != null ? timeOfAction.hashCode() : 0);
        result = 31 * result + countRemainingTrain;
        result = 31 * result + (user != null ? user.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Subscription{" +
                "id=" + id +
                ", timeOfAction=" + timeOfAction +
                ", countRemainingTrain=" + countRemainingTrain +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getTimeOfAction() {
        return timeOfAction;
    }

    public void setTimeOfAction(LocalDate timeOfAction) {
        this.timeOfAction = timeOfAction;
    }

    public int getCountRemainingTrain() {
        return countRemainingTrain;
    }

    public void setCountRemainingTrain(int countRemainingTrain) {
        this.countRemainingTrain = countRemainingTrain;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
