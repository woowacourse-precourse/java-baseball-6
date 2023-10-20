package baseball.converter;

import baseball.constant.BaseballString;
import baseball.state.AfterBaseballState;

public class AfterBaseballStateConverter {
    public static AfterBaseballState stringToAfterBaseballState(String s) throws IllegalArgumentException {
        if (s.equals(BaseballString.RESTART_INPUT.toString())) {
            return AfterBaseballState.RESTART_GAME;
        }
        if (s.equals(BaseballString.ENDGAME_INPUT.toString())) {
            return AfterBaseballState.END_GAME;
        }
        throw new IllegalArgumentException();
    }
}
