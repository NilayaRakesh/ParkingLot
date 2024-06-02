package models;

import exceptions.InvalidParkingException;
import exceptions.ParkingUnavailableException;

import java.util.Arrays;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

public class ParkingSpace {

    private final String id;
    private final Set<VehicleWheelConfiguration> allowedVehicleWheelConfigurations;
    private final int distanceFromGate;
    private boolean occupied;
    private Vehicle occupiedBy;

    public ParkingSpace(int distanceFromGate, Set<VehicleWheelConfiguration> allowedVehicleWheelConfigurations) {
        this.id = UUID.randomUUID().toString();
        this.allowedVehicleWheelConfigurations = allowedVehicleWheelConfigurations;
        this.distanceFromGate = distanceFromGate;
        this.occupied = false;
    }

    public ParkingSpace(int distanceFromGate, VehicleWheelConfiguration... allowedVehicleWheelConfigurations) {
        this.id = UUID.randomUUID().toString();
        this.allowedVehicleWheelConfigurations = Arrays.stream(allowedVehicleWheelConfigurations).collect(Collectors.toSet());
        this.distanceFromGate = distanceFromGate;
        this.occupied = false;
    }

    public void park(Vehicle vehicle) {
        if (isOccupied()) {
            throw new ParkingUnavailableException("Parking space already occupied");
        }

        if (!allowedVehicleWheelConfigurations.contains(vehicle.getWheelConfiguration())) {
            throw new InvalidParkingException("Parking inappropriate for vehicle");
        }

        this.occupiedBy = vehicle;
        this.occupied = true;
    }

    public Vehicle unPark() {
        Vehicle vehicle = this.occupiedBy;
        this.occupiedBy = null;
        this.occupied = false;
        return vehicle;
    }

    public String getId() {
        return id;
    }

    public Set<VehicleWheelConfiguration> getAllowedVehicleWheelConfigurations() {
        return allowedVehicleWheelConfigurations;
    }

    public int getDistanceFromGate() {
        return distanceFromGate;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public Vehicle getOccupiedBy() {
        return occupiedBy;
    }


}
