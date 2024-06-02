package service;

import models.ParkingSpace;
import models.Vehicle;

import java.util.Set;

public interface ParkingStrategy {

    ParkingSpace selectParkingSpace(Vehicle vehicle, Set<ParkingSpace> parkingSpaces);
}
