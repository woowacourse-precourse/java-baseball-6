package exceptions;

public class InvalidNumberException extends RuntimeException {

    public InvalidNumberException() {
        super();
    }

    public InvalidNumberException(String msg) {
        super(msg);
    }
}
