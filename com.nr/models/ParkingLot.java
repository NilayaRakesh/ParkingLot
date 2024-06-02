package models;

import exceptions.InvalidParkingException;
import service.ParkingStrategy;
import service.PricingStrategy;
import service.PricingStrategyResolver;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class ParkingLot {

    private final Set<ParkingSpace> spaces;
    private final PricingStrategyResolver pricingStrategyResolver = PricingStrategyResolver.getInstance();

    public ParkingLot(Set<ParkingSpace> spaces) {
        this.spaces = spaces;
    }

    public ParkingLot(ParkingSpace... spaces) {
        this.spaces = Arrays.stream(spaces).collect(Collectors.toSet());
    }

    public ParkingToken enter(Vehicle vehicle, ParkingStrategy parkingStrategy) {
        ParkingSpace parkingSpace = parkingStrategy.selectParkingSpace(vehicle, spaces);
        parkingSpace.park(vehicle);
        return new ParkingToken(vehicle, parkingSpace);
    }

    public double exit(ParkingToken token) {
        if (!token.isValid()) {
            throw new InvalidParkingException("Token invalid");
        }

        ParkingSpace parkingSpace = spaces.stream().filter(space -> space.getId().equals(token.getParkingSpace().getId()))
                .findFirst()
                .orElseThrow(() -> new InvalidParkingException("No such parking space exists in the parking lot"));
        parkingSpace.unPark();

        PricingStrategy pricingStrategy = pricingStrategyResolver.getPricingStrategy(token.getVehicle().getWheelConfiguration());
        double amount = pricingStrategy.calculateAmount(token);
        token.invalidate();
        return amount;
    }

    public Set<ParkingSpace> getSpaces() {
        return spaces;
    }
}
