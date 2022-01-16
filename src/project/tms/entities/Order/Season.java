package project.tms.entities.Order;

public enum Season {
    MONTH,
    SIX_MONTHS,
    YEAR;

    @Override
    public String toString() {
        return name().toLowerCase();
    }
}
