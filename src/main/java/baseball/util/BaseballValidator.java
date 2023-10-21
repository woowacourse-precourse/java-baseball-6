package baseball.util;

import baseball.config.GameConfig;
import java.util.List;

public class BaseballValidator {

    private static final int BANNED_NUMBER = GameConfig.BANNED_NUMBER;
    private static final int BASEBALL_LENGTH = GameConfig.BASEBALL_LENGTH;

    public static void validate(List<Integer> numbers) {
        validateLength(numbers);
        validateNoBannedNumber(numbers);
        validateNoDuplicateNumbers(numbers);
    }

    private static void validateLength(List<Integer> numbers) {
        if (numbers.size() != BASEBALL_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateNoBannedNumber(List<Integer> numbers) {
        if (numbers.contains(BANNED_NUMBER)) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateNoDuplicateNumbers(List<Integer> numbers) {
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException();
        }
    }
}
