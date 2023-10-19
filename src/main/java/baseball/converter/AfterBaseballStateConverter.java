package baseball.converter;

import baseball.state.AfterBaseballState;

public class AfterBaseballStateConverter {
    public static AfterBaseballState stringToAfterBaseballState(String s) throws IllegalArgumentException {
        if (s.equals("1")) {
            return AfterBaseballState.RESTART_GAME;
        }
        if (s.equals("2")) {
            return AfterBaseballState.END_GAME;
        }
        throw new IllegalArgumentException();
    }
}
