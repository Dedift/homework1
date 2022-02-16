package project.tms.daoLayer.entityLayer.Order;

import project.tms.daoLayer.entityLayer.User.User;

public class Order {
    private static final int HUNDRED = 100;
    private static final double MAX_SALE = 0.2;
    private static final int PRICE_ONE_TRAIN = 7;
    private static final int COUNT_TRAIN_FOR_MAX_SALE = 20;
    private static final int PRICE_FOR_MONTH = 70;
    private static final int PRICE_FOR_SIX_MONTHS = 380;
    private static final int PRICE_FOR_YEAR = 600;
    private int id;
    private int countTrain;
    private String purpose;
    private String season;
    private int price;
    private User user;

    public Order() {
    }

    public Order(int countTrain, String purpose) {
        this.countTrain = countTrain;
        this.purpose = purpose;
        this.price = mathPriceByCountTrain();
    }


    public Order(String season, String purpose) {
        this.season = season;
        this.purpose = purpose;
        this.price = mathPriceBySeason();
    }


    private int mathPriceBySeason() {
        int result = -1;
            switch (this.season) {
                case Season.MONTH -> result = PRICE_FOR_MONTH;
                case Season.SIX_MONTHS -> result = PRICE_FOR_SIX_MONTHS;
                case Season.YEAR -> result = PRICE_FOR_YEAR;
            }
        return result;
    }

    private int mathPriceByCountTrain() {
        int result = -1;
            result = this.countTrain * PRICE_ONE_TRAIN - mathSale();
        return result;
    }

    private int mathSale() {
        if (this.countTrain <= COUNT_TRAIN_FOR_MAX_SALE) {
            return (int) Math.round((this.countTrain * PRICE_ONE_TRAIN) * (double) this.countTrain / HUNDRED);
        } else {
            return (int) Math.round((this.countTrain * PRICE_ONE_TRAIN) * MAX_SALE);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        if (id != order.id) return false;
        if (countTrain != order.countTrain) return false;
        if (price != order.price) return false;
        if (purpose != null ? !purpose.equals(order.purpose) : order.purpose != null) return false;
        if (season != null ? !season.equals(order.season) : order.season != null) return false;
        return user != null ? user.equals(order.user) : order.user == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + countTrain;
        result = 31 * result + (purpose != null ? purpose.hashCode() : 0);
        result = 31 * result + (season != null ? season.hashCode() : 0);
        result = 31 * result + price;
        result = 31 * result + (user != null ? user.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", countTrain=" + countTrain +
                ", purpose='" + purpose + '\'' +
                ", season='" + season + '\'' +
                ", price=" + price +
                ", user=" + user +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCountTrain() {
        return countTrain;
    }

    public void setCountTrain(int countTrain) {
        this.countTrain = countTrain;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

