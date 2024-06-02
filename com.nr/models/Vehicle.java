package models;

public class Vehicle {
    private String vehicleNumber;
    private VehicleWheelConfiguration wheelConfiguration;

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public VehicleWheelConfiguration getWheelConfiguration() {
        return wheelConfiguration;
    }

    public void setWheelConfiguration(VehicleWheelConfiguration wheelConfiguration) {
        this.wheelConfiguration = wheelConfiguration;
    }
}
