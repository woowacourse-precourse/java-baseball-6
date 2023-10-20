package baseball.converter;

import static baseball.constant.BaseballStrings.ENDGAME_INPUT;
import static baseball.constant.BaseballStrings.RESTART_INPUT;

import baseball.state.AfterBaseballState;

public class AfterBaseballStateConverter {

    public static AfterBaseballState stringToAfterBaseballState(String s) throws IllegalArgumentException {
        if (s.equals(ENDGAME_INPUT.toString())) {
            return AfterBaseballState.IS_END;
        }
        if (s.equals(RESTART_INPUT.toString())) {
            return AfterBaseballState.IS_RESTART;
        }
        throw new IllegalArgumentException();
    }
}
