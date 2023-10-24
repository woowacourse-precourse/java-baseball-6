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
        validateLength(input);
        validateDigitRange(input);
        validateDistinctDigit(input);
    }

    private static void validateLength(String input) {
        if (input.length() != 3) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateDigitRange(String input) {
        input.chars().forEach(digit -> {
            if (digit < '1' || digit > '9') {
                throw new IllegalArgumentException();
            }
        });
    }

    private static void validateDistinctDigit(String input) {
        long count = input.chars().distinct().count();
        
        if (count != 3) {
            throw new IllegalArgumentException();
        }
    }
}
