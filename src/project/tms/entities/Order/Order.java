package project.tms.entities.Order;

import project.tms.entities.Train.Purpose;

public class Order {

    private int id;
    private int countTrain;
    private Enum<Purpose> purpose;
    private Enum<Season> season;

public Order(){
}
    public Order(int countTrain, Enum<Purpose> purpose) {
        this.countTrain = countTrain;
        this.purpose = purpose;
    }

    public Order(Enum<Season> season, Enum<Purpose> purpose) {
        this.purpose = purpose;
        this.season = season;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        if (id != order.id) return false;
        if (countTrain != order.countTrain) return false;
        if (purpose != null ? !purpose.equals(order.purpose) : order.purpose != null) return false;
        return season != null ? season.equals(order.season) : order.season == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + countTrain;
        result = 31 * result + (purpose != null ? purpose.hashCode() : 0);
        result = 31 * result + (season != null ? season.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", countTrain=" + countTrain +
                ", purpose=" + purpose +
                ", season=" + season +
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

    public Enum<Purpose> getPurpose() {
        return purpose;
    }

    public void setPurpose(Enum<Purpose> purpose) {
        this.purpose = purpose;
    }

    public Enum<Season> getSeason() {
        return season;
    }

    public void setSeason(Enum<Season> season) {
        this.season = season;
    }
}

