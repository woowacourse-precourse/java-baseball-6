package baseball.constant;

import static baseball.constant.MessageConstants.CANNOT_INSTANTIATE;

public class NumberConstants {

    public static final String RESTART_NUMBER_STRING = "1";
    public static final String EXIT_NUMBER_STRING = "2";
    public static final int ONE_LENGTH = 1;
    public static final int THREE_LENGTH = 3;
    public static final int MIN_VALUE = 1;
    public static final int MAX_VALUE = 9;
    public static final int GAME_END_CONDITION = 3;
    public static final int COUNT_ZERO = 0;

    private NumberConstants() {
        throw new AssertionError(CANNOT_INSTANTIATE);
    }

}
