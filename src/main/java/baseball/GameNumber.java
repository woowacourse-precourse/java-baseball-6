package baseball;

public class GameNumber {
    public static final int NUMBER_LENGTH = 3;
    private final String value;

    private GameNumber(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public char getCharAt(int index) {
        return value.charAt(index);
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
        return hasProperLength(input) && hasProperRange(input) && hasDistinctDigits(input);
    }

    private static boolean hasProperLength(String input) {
        return input.length() == NUMBER_LENGTH;
    }

    private static boolean hasProperRange(String input) {
        return input.chars().allMatch(digit -> digit >= '1' && digit <= '9');
    }

    private static boolean hasDistinctDigits(String input) {
        return input.chars().distinct().count() == NUMBER_LENGTH;
    }
}
