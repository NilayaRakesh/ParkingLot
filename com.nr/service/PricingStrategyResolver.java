package service;

import exceptions.InvalidParkingException;
import models.VehicleWheelConfiguration;

public class PricingStrategyResolver {

    private final PricingStrategy twoWheelerPricingStrategy;
    private final PricingStrategy fourWheelerPricingStrategy;

    private static PricingStrategyResolver instance;

    private PricingStrategyResolver() {
        this.twoWheelerPricingStrategy = TwoWheelerPricingStrategy.getInstance();
        this.fourWheelerPricingStrategy = FourWheelerPricingStrategy.getInstance();
    }

    public static PricingStrategyResolver getInstance() {
        if (instance == null) {
            instance = new PricingStrategyResolver();
        }

        return instance;
    }

    public PricingStrategy getPricingStrategy(VehicleWheelConfiguration vehicleWheelConfiguration) {
        switch (vehicleWheelConfiguration) {
            case TWO_WHEELER -> {
                return twoWheelerPricingStrategy;
            }
            case FOUR_WHEELER -> {
                return fourWheelerPricingStrategy;
            }
            default -> throw new InvalidParkingException("Unsupported vehicle wheel configuration");
        }
    }
}
