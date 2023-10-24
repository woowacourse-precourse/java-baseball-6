package baseball.validation;

public class BaseballNumberValidator {

    private static final int MIN_RANGE = 1;
    private static final int MAX_RANGE = 9;

    private static final String RANGE_ERROR_MESSAGE = "숫자는 1에서 9 사이의 값이어야 합니다.";
    private static final String DUPLICATE_ERROR_MESSAGE = "모든 숫자는 서로 달라야 합니다.";

    public static void validate(int first, int second, int third) {
        checkValidRange(first, second, third);
        checkNumbersDistinct(first, second, third);
    }

    private static void checkValidRange(int first, int second, int third) {
        if (!isInRange(first) || !isInRange(second) || !isInRange(third)) {
            throw new IllegalArgumentException(RANGE_ERROR_MESSAGE);
        }
    }

    private static boolean isInRange(int value) {
        return value >= MIN_RANGE && value <= MAX_RANGE;
    }

    private static void checkNumbersDistinct(int first, int second, int third) {
        if (first == second || first == third || second == third) {
            throw new IllegalArgumentException(DUPLICATE_ERROR_MESSAGE);
        }
    }
}
