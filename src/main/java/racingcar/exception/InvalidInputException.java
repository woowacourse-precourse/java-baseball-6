package racingcar.exception;

public class InvalidInputException extends IllegalArgumentException {
    private String input;
    public InvalidInputException() {
        super();
    }

    public InvalidInputException(String errorMessage, String input) {
        super(errorMessage);
        this.input = input;
    }

    @Override
    public String getMessage() {
        return super.getMessage() + " : " + input;
    }
}
