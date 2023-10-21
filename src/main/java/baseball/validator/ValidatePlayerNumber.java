package baseball.validator;

import baseball.util.Constants;
import baseball.util.ExceptionMessage;

public class ValidatePlayerNumber {

    public static void validate(String numbers) {
        validateNumberLength(numbers);
        validateNaturalNumber(numbers);
        validateDuplicatedNumber(numbers);
        validateNumberInRange(numbers);
    }

    private static void validateNumberLength(String numbers) {
        if (numbers.length() != Constants.BALL_LENGTH) {
            throw new IllegalArgumentException(ExceptionMessage.WRONG_NUMBER_LENGTH);
        }
    }

    private static void validateNaturalNumber(String numbers) {
        try {
            int n = Integer.parseInt(numbers);
        } catch (Error e) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_NATURAL_NUMBER);
        }
    }

    private static void validateDuplicatedNumber(String numbers) {
        long uniqueCount = numbers.chars().distinct().count();
        if (uniqueCount != Constants.BALL_LENGTH) {
            throw new IllegalArgumentException(ExceptionMessage.HAS_DUPLICATED_NUMBER);
        }
    }

    private static void validateNumberInRange(String numbers) {
        boolean allInRange = numbers.chars()
                .mapToObj(Character::getNumericValue)
                .allMatch(num -> num >= Constants.MIN_BALL_NUMBER && num <= Constants.MAX_BALL_NUMBER);
        if (!allInRange) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_IN_RANGE);
        }
    }

}
