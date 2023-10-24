package validation;

public class Validator extends Exception {
    private Validator() {
    }

    public static void validateOneOrTwo(String input) {
        if (!input.matches("[1-2]")) throw new IllegalArgumentException();
    }

    public static void validateInput(String input) {
        if (!input.matches("[1-9]{3}") || hasDuplicateDigits(input)) {
            throw new IllegalArgumentException();
        }
    }

    public static boolean hasDuplicateDigits(String input) {
        return input.chars().distinct().count() < input.length();
    }
}
