package project.tms.entities.User;

public enum Gender {
    MALE,
    FEMALE;

    @Override
    public String toString() {
        return name().toLowerCase();
    }
}
