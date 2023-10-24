package baseball.model;

import static baseball.utils.BaseballConstantUtils.GAME_OVER;
import static baseball.utils.BaseballConstantUtils.GAME_RESTART;

/**
 * 유저에게 입력 받은 게임 재시작 여부 String 값을 포장하는 클래스입니다.
 */

public class GameRestartString {
    private final String gameRestartString;

    /**
     * 입력 받은 String이 게임 재시작 여부를 판단하는데 사용 가능한지 검증 후 객체로 반환합니다.
     *
     * @param gameRestartString 콘솔을 통해 유저에게 입력받은 String 값
     */

    public GameRestartString(String gameRestartString) {
        validateGameRestartString(gameRestartString);
        this.gameRestartString = gameRestartString;
    }

    private void validateGameRestartString(String gameRestartString) {
        if (!GAME_RESTART.equals(gameRestartString) && !GAME_OVER.equals(gameRestartString)) {
            throw new IllegalArgumentException("[ERROR] 1 또는 2의 값이 아닙니다.");
        }
    }

    /**
     * 유저가 게임 재시작을 원하는지 판단합니다.
     *
     * @return 객체가 게임 재시작을 의미하는지 판단한 값
     */

    public boolean doesRestart() {
        return GAME_RESTART.equals(gameRestartString);
    }
}
