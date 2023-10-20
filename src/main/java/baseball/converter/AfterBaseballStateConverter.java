package baseball.converter;

import static baseball.constant.BaseballStrings.ENDGAME_INPUT;
import static baseball.constant.BaseballStrings.RESTART_INPUT;

import baseball.state.AfterBaseballState;

public class AfterBaseballStateConverter {

    public static AfterBaseballState stringToAfterBaseballState(String s) throws IllegalArgumentException {
        if (ENDGAME_INPUT.equals(s)) {
            return AfterBaseballState.IS_END;
        }
        if (RESTART_INPUT.equals(s)) {
            return AfterBaseballState.IS_RESTART;
        }
        throw new IllegalArgumentException();
    }
}
