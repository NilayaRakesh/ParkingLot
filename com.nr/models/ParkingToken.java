package models;

import java.time.LocalDateTime;

public class ParkingToken {

    private final Vehicle vehicle;
    private final ParkingSpace parkingSpace;
    private final LocalDateTime startDateTime;
    private boolean valid;

    public ParkingToken(Vehicle vehicle, ParkingSpace parkingSpace) {
        this.vehicle = vehicle;
        this.parkingSpace = parkingSpace;
        this.startDateTime = LocalDateTime.now();
        this.valid = true;
    }

    public void invalidate() {
        this.valid = false;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public ParkingSpace getParkingSpace() {
        return parkingSpace;
    }

    public LocalDateTime getStartDateTime() {
        return startDateTime;
    }

    public boolean isValid() {
        return valid;
    }
}
