package baseball.model;

import static baseball.utils.BaseballConstantUtils.GAME_OVER;
import static baseball.utils.BaseballConstantUtils.GAME_RESTART;

public class GameRestartString {
    private final String gameRestartString;

    public GameRestartString(String gameRestartString) {
        validateStringGameRestartOrNot(gameRestartString);
        this.gameRestartString = gameRestartString;
    }

    private void validateStringGameRestartOrNot(String gameRestartString) {
        if (!GAME_RESTART.equals(gameRestartString) && !GAME_OVER.equals(gameRestartString)) {
            throw new IllegalArgumentException("[ERROR] 1 또는 2의 값이 아닙니다.");
        }
    }

    public boolean doesRestart() {
        return GAME_RESTART.equals(gameRestartString);
    }
}
