package exceptions;

public class InvalidParkingException extends RuntimeException {

    public InvalidParkingException(String message) {
        super(message);
    }
}
