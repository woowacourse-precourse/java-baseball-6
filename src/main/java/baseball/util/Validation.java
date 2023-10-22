package baseball.util;

public class Validation {

    private final int MAX_INPUT_LENGTH = 3;
    private final int MAX_EXIT_INPUT_LENGTH = 1;

    private boolean containsZero(String number) {
        return number.contains("0");
    }
}
