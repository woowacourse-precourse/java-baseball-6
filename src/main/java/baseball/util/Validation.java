package baseball.util;

public class Validation {

    private final int MAX_INPUT_LENGTH = 3;
    private final int MAX_EXIT_INPUT_LENGTH = 1;

    private boolean containsZero(String number) {
        return number.contains("0");
    }

    private boolean containsLetter(String number, int maxLength) {
        String tmp = number.replaceAll("[^1-9]", "");

        return tmp.length() < maxLength;
    }

    private boolean validLength(String number, int maxLength) {
        return number.length() != maxLength;
    }
}
