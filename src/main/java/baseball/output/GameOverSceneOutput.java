package baseball.output;

import baseball.game.GameConstants;

public class GameOverSceneOutput {
    private static final String STRING_END_MESSAGE =
            GameConstants.SIZE_RANDOM_NUMBER + "개의 숫자를 모두 맞히셨습니다! 게임 종료\n"
            + "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public GameOverSceneOutput() {
        // Empty
    }

    public void printEndMessage() {
        System.out.println(STRING_END_MESSAGE);
    }
}
