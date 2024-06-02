package service;

import models.ParkingToken;

public interface PricingStrategy {

    double calculateAmount(ParkingToken token);
}
