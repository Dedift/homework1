package project.tms.entities.Train;

public enum Purpose {
    MUSCLE,
    FAT_BURNING;

    @Override
    public String toString() {
        return name().toLowerCase();
    }
}
