package baseball;

public class InputValidator {

    public static void validateNumberInput(String input) {
        if (!input.matches("\\d+")) {
            throw new IllegalArgumentException(GameConstants.NOT_A_NUMBER);
        }

        if (input.length() != GameConstants.LIST_SIZE) {
            throw new IllegalArgumentException(GameConstants.NOT_VALID_LENGTH);
        }

        if (hasDuplicateNumbers(input)) {
            throw new IllegalArgumentException(GameConstants.DUPLICATE_NUMBER);
        }

        if (!isWithinRange(input)) {
            throw new IllegalArgumentException(GameConstants.OUT_OF_RANGE);
        }
    }

    private static boolean hasDuplicateNumbers(String input) {
        return input.chars().distinct().count() != input.length();
    }

    private static boolean isWithinRange(String input) {
        return input.chars().allMatch(ch -> ch >= 1 + '0' && ch <= 9 + '0');
    }

    public static void validateChoiceInput(String input) {
        if (!input.matches("\\d+")) {
            throw new IllegalArgumentException(GameConstants.NOT_A_NUMBER);
        }

        int choice = Integer.parseInt(input);

        if (choice != GameConstants.RESTART_GAME && choice != GameConstants.END_GAME) {
            throw new IllegalArgumentException(GameConstants.NOT_A_VALID_CHOICE);
        }
    }
}
