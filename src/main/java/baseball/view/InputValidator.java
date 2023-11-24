package baseball.view;

public class InputValidator {

    private static final String NUMBER_FORMAT_EX_MESSAGE = "숫자가 아닙니다.";

    public void validateNumberFormat(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NUMBER_FORMAT_EX_MESSAGE);
        }
    }
}
