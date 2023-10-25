package baseball;

import java.util.Arrays;
import java.util.List;

public class InputValidator {
    private static final int NUMBER_LENGTH = 3;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;

    private static final String REPLAY = "1";
    private static final String QUIT = "2";

    public static void validatePlayerNumbers(String input) {
        if (input.length() != NUMBER_LENGTH) {
            throwException("3자리의 수를 입력하세요.");
        }

        List<String> playerNumbers = Arrays.stream(input.split("")).toList();
        if (isDuplicate(playerNumbers)) {
            throwException("서로 다른 3자리의 수를 입력하세요.");
        }
        if (isOutOfSingleDigitRange(playerNumbers)) {
            throwException("1부터 9까지의 수를 입력하세요.");
        }
    }

    public static void validateReplayChoice(String input) {
        if (!input.equals(REPLAY) && !input.equals(QUIT)) {
            throwException("재시작하려면 1, 종료하려면 2를 입력하세요.");
        }
    }

    private static boolean isDuplicate(List<String> numbers) {
        return numbers.stream().distinct().toList().size() != NUMBER_LENGTH;
    }

    private static boolean isOutOfSingleDigitRange(List<String> numbers) {
        try {
            return numbers.stream().anyMatch(letter -> {
                int num = Integer.parseInt(letter);
                return (num < MIN_NUMBER || num > MAX_NUMBER);
            });
        } catch (NumberFormatException exception) {
            return true;
        }
    }

    private static void throwException(String errorMessage) {
        throw new IllegalArgumentException(errorMessage);
    }
}
