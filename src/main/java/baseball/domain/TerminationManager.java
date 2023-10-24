package baseball.domain;

import static baseball.console.Constant.EXCEPTION_RESTART_CONDITION_FORMAT_MESSAGE;

import baseball.console.Constant;

public class TerminationManager {

    private static final int RESTART_NUMBER = 1;
    private static final int TERMINATION_NUMBER = 2;

    private final int number;

    public TerminationManager(String condition) {
        int num = condition.charAt(0) - Constant.CHAR_ZERO;
        isValidFormat(num);
        this.number = num;
    }

    private static void isValidFormat(int number) {

        if (number != RESTART_NUMBER && number != TERMINATION_NUMBER) {
            throw new IllegalArgumentException(EXCEPTION_RESTART_CONDITION_FORMAT_MESSAGE);
        }
    }

    boolean isRestart() {
        return number == RESTART_NUMBER;
    }
}
