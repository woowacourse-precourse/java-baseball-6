package baseball.util;

import baseball.util.constants.BaseballGameConstants;

public class RestartOptionConverter implements InputConverter {

    private static final String WRONG_RESTART_OPTION_MESSAGE = "입력은 %s 또는 %s만 가능합니다".formatted(
            BaseballGameConstants.RESTART_OPTION_RESTART, BaseballGameConstants.RESTART_OPTION_EXIT);


    public static boolean convert(String input) {
        if (input.equals(BaseballGameConstants.RESTART_OPTION_RESTART)
                || input.equals(BaseballGameConstants.RESTART_OPTION_EXIT)) {
            return input.equals(BaseballGameConstants.RESTART_OPTION_RESTART);
        }
        throw new IllegalArgumentException(
                String.format(ILLEGAL_INPUT_EXCEPTION_MESSAGE, WRONG_RESTART_OPTION_MESSAGE, input));
    }
}
