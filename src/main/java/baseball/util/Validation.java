package baseball.util;

public class Validation {

    private static final String NUMBER_REGEX = "^[1-9]+$";
    private static final String RESTART_NUMBER_REGEX = "^[1-2]+$";
    private static final Integer INPUT_LENGTH = 3;

    private static final Integer RESTART_LENGTH = 1;

    public String validateNumber(String number) {
        checkRightNumber(number);
        return number;
    }


    public void validateRestart(String number) {
        checkRightRestartNumber(number);
        validateRestartNumberLength(number);
    }

    private static void checkRightRestartNumber(String number) {
        if (!number.matches(RESTART_NUMBER_REGEX)) {
            throw new IllegalArgumentException("재시작 관련 입력은 1 또는 2의 숫자여야 합니다! ");
        }
    }

    private static void validateRestartNumberLength(String number) {
        if (number.length() != RESTART_LENGTH) {
            throw new IllegalArgumentException("1 또는 2 의 숫자로 한 번만 입력해주세요!");
        }
    }

    private void checkRightNumber(String number) {
        validateIsNumber(number);
        validateIsRightLength(number);
        validateInSameNumber(number);
    }

    private void validateInSameNumber(String number) {
        for (int i = 0; i < INPUT_LENGTH; i++) {
            for (int j = 0; j < INPUT_LENGTH; j++) {
                findDuplicateNumber(number, i, j);
            }
        }
    }

    private static void findDuplicateNumber(String number, int i, int j) {
        if (i != j) {
            if (number.charAt(i) == number.charAt(j)) {
                throw new IllegalArgumentException("서로 다른 숫자가 와야 합니다! ");
            }
        }
    }

    private void validateIsNumber(String number) {
        if (!number.matches(NUMBER_REGEX)) {
            throw new IllegalArgumentException("숫자로 입력이 되어야 합니다!");
        }
    }

    private void validateIsRightLength(String number) {
        if (number.length() != INPUT_LENGTH) {
            throw new IllegalArgumentException("입력 숫자의 길이는 3입니다!");
        }
    }


}
