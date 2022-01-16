package project.tms.entities.Train;

public enum Exercise {
    JIM,
    PRISED,
    BEG,
    PRESS;

    @Override
    public String toString() {
        return name().toLowerCase();
    }
}
