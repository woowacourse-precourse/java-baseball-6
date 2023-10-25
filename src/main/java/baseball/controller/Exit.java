package baseball.controller;

import baseball.view.Input;

public class Exit {
    private static final String REPLAY_NUM = "1";
    private static final String EXIT_NUM = "2";
    public static boolean isReplay() {
        String isExit = Input.inputIsExit();

        if (isExit.equals(REPLAY_NUM)) {
            return true;
        } else if (isExit.equals(EXIT_NUM)) {
            Input.scannerClose();
            return false;
        }
        else {
            try {
                Input.scannerClose();
                throw new IllegalArgumentException("1 또는 2 입력.");
            } catch (IllegalArgumentException e) {
                return false;
            }
        }
    }
}
