package baseball;

import java.util.Arrays;
import java.util.Optional;

public class Validator {

    private static final Validator instance = new Validator();

    private Validator() {
    }

    public static Validator getInstance() {
        return instance;
    }

    public static void validateInput(final String input) {
        validateInputDigit(input);
        validateInputRange(input);
        validateInputContainsZero(input);
    }

    private static void validateInputRange(final String input) {
        if (input.length() == Const.NUMBER_LENGTH) return;
        throw new IllegalStateException();
    }

    private static void validateInputDigit(final String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalStateException(e);
        }
    }

    private static void validateInputContainsZero(final String input) {
        String[] split = input.split("");
        if (Arrays.asList(split).contains("0")) {
            throw new IllegalStateException();
        }
    }
}
