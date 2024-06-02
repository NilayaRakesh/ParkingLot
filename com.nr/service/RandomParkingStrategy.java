package service;

import exceptions.ParkingUnavailableException;
import models.ParkingSpace;
import models.Vehicle;

import java.util.Set;

public class RandomParkingStrategy implements ParkingStrategy {

    private static RandomParkingStrategy instance;

    private RandomParkingStrategy() {
    }

    public static RandomParkingStrategy getInstance() {
        if (instance == null) {
            instance = new RandomParkingStrategy();
        }

        return instance;
    }

    @Override
    public ParkingSpace selectParkingSpace(Vehicle vehicle, Set<ParkingSpace> parkingSpaces) {
        return parkingSpaces.stream()
                .filter(space -> !space.isOccupied() && space.getAllowedVehicleWheelConfigurations().contains(vehicle.getWheelConfiguration()))
                .findFirst()
                .orElseThrow(() -> new ParkingUnavailableException("No appropriate parking space available"));
    }
}
