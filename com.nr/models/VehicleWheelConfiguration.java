package models;

public enum VehicleWheelConfiguration {
    TWO_WHEELER(2),
    FOUR_WHEELER(4);

    private final int numWheel;

    VehicleWheelConfiguration(int numWheels) {
        this.numWheel = numWheels;
    }

    public int getNumWheel() {
        return numWheel;
    }
}
