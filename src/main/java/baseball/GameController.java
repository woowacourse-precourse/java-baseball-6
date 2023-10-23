package baseball;

import baseball.dto.Result;

public class GameController {

    public static final int INPUT_LENGTH = 3;
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 9;
    public static final int GAME_AGAIN_CODE = 1;
    public static final int GAME_TERMINATE_CODE = 2;

    public static boolean isWin(Result result) {
        if (result.getStrike() == INPUT_LENGTH) {
            return true;
        } else {
            return false;
        }
    }
}
