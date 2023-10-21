package baseball.model;

public class RestartNumberValidator {
    private static final String INPUT_LENGTH_IS_NOT_ONE = "입력한 값의 길이가 1이 아닙니다.";
    private static final String INPUT_IS_NOT_VALID_NUMBER = "입력한 숫자가 유효하지 않은 값입니다.";
    private static final String RESTART_NUMBER = "1";
    private static final String FINISH_NUMBER = "2";
    private static final int RESTART_FINISH_NUMBER_LENGTH = 1;

    public static void validate(String restartNumber) {
        if (!hasValidLength(restartNumber)) {
            throw new IllegalArgumentException(INPUT_LENGTH_IS_NOT_ONE);
        }
        if (!isInValidRange(restartNumber)) {
            throw new IllegalArgumentException(INPUT_IS_NOT_VALID_NUMBER);
        }
    }

    private static boolean hasValidLength(String restartNumber) {
        return restartNumber.length() == RESTART_FINISH_NUMBER_LENGTH;
    }

    private static boolean isInValidRange(String restartNumber) {
        return RESTART_NUMBER.equals(restartNumber) || FINISH_NUMBER.equals(restartNumber);
    }
}
