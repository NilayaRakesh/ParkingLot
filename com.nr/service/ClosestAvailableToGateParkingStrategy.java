package service;

import exceptions.ParkingUnavailableException;
import models.ParkingSpace;
import models.Vehicle;

import java.util.Comparator;
import java.util.Set;

public class ClosestAvailableToGateParkingStrategy implements ParkingStrategy {

    private static ClosestAvailableToGateParkingStrategy instance;

    private ClosestAvailableToGateParkingStrategy() {
    }

    public static ClosestAvailableToGateParkingStrategy getInstance() {
        if (instance == null) {
            instance = new ClosestAvailableToGateParkingStrategy();
        }

        return instance;
    }

    @Override
    public ParkingSpace selectParkingSpace(Vehicle vehicle, Set<ParkingSpace> parkingSpaces) {
        return parkingSpaces.stream()
                .filter(space -> !space.isOccupied() && space.getAllowedVehicleWheelConfigurations().contains(vehicle.getWheelConfiguration()))
                .min(Comparator.comparingInt(ParkingSpace::getDistanceFromGate))
                .orElseThrow(() -> new ParkingUnavailableException("No appropriate parking space available"));
    }
}
