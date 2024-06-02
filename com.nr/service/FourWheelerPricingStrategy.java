package service;

import models.ParkingToken;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class FourWheelerPricingStrategy implements PricingStrategy {

    private static final double PER_MIN_RATE = 1.0;

    private static FourWheelerPricingStrategy instance;

    private FourWheelerPricingStrategy() {
    }

    public static FourWheelerPricingStrategy getInstance() {
        if (instance == null) {
            instance = new FourWheelerPricingStrategy();
        }

        return instance;
    }

    @Override
    public double calculateAmount(ParkingToken token) {
        long numMinutes = token.getStartDateTime().until(LocalDateTime.now(), ChronoUnit.MINUTES);
        return numMinutes * PER_MIN_RATE;
    }
}
