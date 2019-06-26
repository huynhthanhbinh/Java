package bht_exception;

public class InvalidAgeException extends RuntimeException {
    private String message;
    private Throwable cause;

    public InvalidAgeException(String message) {
        super(message);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
