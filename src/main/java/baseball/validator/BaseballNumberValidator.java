package baseball.validator;

public class BaseballNumberValidator {

    private static final String ERROR_MESSAGE = "1 이상 9 이하 값을 가져야 합니다.";

    //인스턴스화 방지
    private BaseballNumberValidator() {
        throw new AssertionError();
    }

    public static void validate(int number, int inclusiveStart, int inclusiveEnd) {
        validateWithinBounds(number, inclusiveStart, inclusiveEnd);
    }

    private static void validateWithinBounds(int number, int inclusiveStart, int inclusiveEnd) {
        if (!isWithinBounds(number, inclusiveStart, inclusiveEnd)) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
    }

    private static boolean isWithinBounds(int number, int inclusiveStart, int inclusiveEnd) {
        return inclusiveStart <= number && number <= inclusiveEnd;
    }
}
