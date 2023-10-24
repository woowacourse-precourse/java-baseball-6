package baseball.util;

public class InputValidator {
    public static void validateDigitCount(String input) throws IllegalArgumentException {
        if (input == null || input.length() != GameConstants.DIGIT_SIZE || !input.matches("\\d+")) {
            throw new IllegalArgumentException("잘못된 값을 입력하셨습니다.");
        }
    }

    public static void validateDuplicates(String input) throws IllegalArgumentException {
        boolean hasDuplicates = input.chars()
                .distinct()
                .count() < input.length();

        if (hasDuplicates) {
            throw new IllegalArgumentException("잘못된 값을 입력하셨습니다.");
        }
    }

    public static void validateCommand(GameCommand gameCommand) throws IllegalArgumentException {
        if (gameCommand == GameCommand.UNKNOWN_COMMAND) {
            throw new IllegalArgumentException("잘못된 커맨드를 입력하셨습니다.");
        }
    }
}
