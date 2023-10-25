package baseball;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

public class InputException {

    public static void validGameInput(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException("input cannot be empty.");
        }
        if (input.length() != 3) {
            throw new IllegalArgumentException("input length must be three.");
        }
        if (!Pattern.matches("^[1-9]*$", input)) {
            throw new IllegalArgumentException("input must be in 1to9.");
        }
        if (isOverlap(input)) {
            throw new IllegalArgumentException("input cannot be overlap.");
        }
    }

    private static boolean isOverlap(String input) {
        Set<String> inputSet = new HashSet<>(Arrays.asList(input.split("")));
        return input.length() != inputSet.size();
    }

    public static void validRestartInput(String input) {
        if (!input.equals("1") && !input.equals("2")) {
            throw new IllegalArgumentException("input must be 1 or 2.");
        }
    }
}
