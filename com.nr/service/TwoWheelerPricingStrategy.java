package service;

import models.ParkingToken;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class TwoWheelerPricingStrategy implements PricingStrategy {

    private static final double PER_MIN_RATE = 0.5;

    private static TwoWheelerPricingStrategy instance;

    private TwoWheelerPricingStrategy() {
    }

    public static TwoWheelerPricingStrategy getInstance() {
        if (instance == null) {
            instance = new TwoWheelerPricingStrategy();
        }

        return instance;
    }

    @Override
    public double calculateAmount(ParkingToken token) {
        long numMinutes = token.getStartDateTime().until(LocalDateTime.now(), ChronoUnit.MINUTES);
        return numMinutes * PER_MIN_RATE;
    }
}
