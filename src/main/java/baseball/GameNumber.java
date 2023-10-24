package baseball;

public class GameNumber {
    private final String value;

    public String getValue() {
        return value;
    }

    private GameNumber(String value) {
        this.value = value;
    }

    public static GameNumber from(String input) {
        validate(input);
        return new GameNumber(input);
    }

    private static void validate(String input) {
        if (!isValid(input)) {
            throw new IllegalArgumentException();
        }
    }

    public static boolean isValid(String input) {
        return hasThreeDigits(input) && hasProperRange(input) && hasDistinctDigits(input);
    }

    private static boolean hasThreeDigits(String input) {
        return input.length() == 3;
    }

    private static boolean hasProperRange(String input) {
        return input.chars().allMatch(digit -> digit >= '1' && digit <= '9');
    }

    private static boolean hasDistinctDigits(String input) {
        return input.chars().distinct().count() == 3;
    }
}
