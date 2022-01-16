package project.tms.entities.Order;

import project.tms.entities.User.User;

import java.time.LocalDate;

public class Subscription {

    private int id;
    private static final double MAX_SALE = 0.2;
    private static final int PRICE_ONE_TRAIN = 7;
    private static final int COUNT_TRAIN_FOR_MAX_SALE = 21;
    private static final int PRICE_FOR_YEAR = 600;
    private static final int PRICE_FOR_SIX_MONTHS = 380;
    private static final int PRICE_FOR_MONTH = 70;
    private LocalDate timeOfAction;
    private int countRemainingTrain;
    private int price;

    public Subscription(Order order, User user) {
        if (order.getCountTrain() > 0) {
            user.getSubscription().setCountRemainingTrain(user.getSubscription().getCountRemainingTrain() + order.getCountTrain());
            this.price = mathPrice(order.getCountTrain()) - mathSale(order);
        } else {
            this.timeOfAction = mathTimeOfAction(order.getSeason(), user);
            this.price = mathPrice(order.getSeason());
        }
    }

    public Subscription() {

    }

    private LocalDate mathTimeOfAction(Enum<Season> time, User user) {
        LocalDate timeOfAction = user.getSubscription().getTimeOfAction();
        if (time == Season.MONTH) {
            return timeOfAction.plusMonths(1);
        } else if (time == Season.SIX_MONTHS) {
            return timeOfAction.plusMonths(6);
        } else if (time == Season.YEAR) {
            return timeOfAction.plusYears(1);
        }
        return timeOfAction;
    }

    private int mathPrice(int countTrain) {
        return countTrain * PRICE_ONE_TRAIN;
    }

    private int mathPrice(Enum<Season> time) {
        int result = -1;
        if (time == Season.MONTH) {
            result = PRICE_FOR_MONTH;
        } else if (time == Season.SIX_MONTHS) {
            result = PRICE_FOR_SIX_MONTHS;
        } else if (time == Season.YEAR) {
            result = PRICE_FOR_YEAR;
        }
        return result;
    }

    private int mathSale(Order order) {
        if (order.getCountTrain() < COUNT_TRAIN_FOR_MAX_SALE) {
            return (int) Math.round((order.getCountTrain() * PRICE_ONE_TRAIN) * (double) order.getCountTrain() / 100);
        } else {
            return (int) Math.round((order.getCountTrain() * PRICE_ONE_TRAIN) * MAX_SALE);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Subscription that = (Subscription) o;

        if (id != that.id) return false;
        if (countRemainingTrain != that.countRemainingTrain) return false;
        if (price != that.price) return false;
        return timeOfAction != null ? timeOfAction.equals(that.timeOfAction) : that.timeOfAction == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (timeOfAction != null ? timeOfAction.hashCode() : 0);
        result = 31 * result + countRemainingTrain;
        result = 31 * result + price;
        return result;
    }

    @Override
    public String toString() {
        return "Subscription{" +
                "id=" + id +
                ", timeOfAction=" + timeOfAction +
                ", countRemainingTrain=" + countRemainingTrain +
                ", price=" + price +
                '}';
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
