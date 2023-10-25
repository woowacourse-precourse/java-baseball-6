package baseball.controller;

import baseball.view.Input;

public class Exit {
    private static final String RESTART_NUM = "1";
    private static final String END_NUM = "2";
    public static boolean restartOrEnd() {
        String replayOrEnd = Input.inputReplayOrEnd();
        if (replayOrEnd.equals(RESTART_NUM)) {
            return true;
        }
        else if (replayOrEnd.equals(END_NUM)) {
            Input.consoleClose();
            return false;
        }
        else {
            try {
                Input.consoleClose();
                throw new IllegalArgumentException("반드시 1 또는 2를 입력해야 합니다.");
            } catch (IllegalArgumentException e) {
                return false;
            }
        }
    }
}
