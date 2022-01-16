package project.tms.entities.User;

public enum Role {
    ADMIN,
    USER,
    TRAINER;

    @Override
    public String toString() {
        return name().toLowerCase();
    }
}
