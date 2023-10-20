package baseball.converter;

import baseball.constant.BaseballString;
import baseball.state.AfterBaseballState;

public class AfterBaseballStateConverter {
    private static boolean isValidAfterBaseballStateString(String s) {
        // TODO: 아랫녀석과 어떻게 합쳐야하는지 생각해보기
        return true;
    }

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
