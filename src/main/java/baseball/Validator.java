package baseball;

import java.util.List;

public class Validator {
    private static final int MAX_INPUT_SIZE = 3;

    public static void validInputSize(String input) {
        if (input.length() != MAX_INPUT_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    public static void validatePick(List<Pick> picks, Pick newPick) {
        if (picks.contains(newPick)) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean isNumeric(char character) {
        return Character.isDigit(character);
    }

    public static int checkNumber(char character) {
        if (!isNumeric(character)) {
            throw new IllegalArgumentException();
        }
        return Character.getNumericValue(character);
    }
}
