package baseball;

public class Validator {
    private static Constants constants = new Constants();

    public void validateInputBound(String input) {
        if (!input.equals(constants.getCONTINUE()) && !input.equals(constants.getEXIT())) {
            throw new IllegalArgumentException(Message.INPUT_BOUND_ERROR.getMessage());
        }
    }

    public void validateInputSize(String input) {
        if (input.length() != 3) {
            throw new IllegalArgumentException(Message.INPUT_SIZE_ERROR.getMessage());
        }
    }
}