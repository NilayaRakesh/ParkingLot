package exceptions;

public class ParkingUnavailableException extends RuntimeException {

    public ParkingUnavailableException(String message) {
        super(message);
    }
}
