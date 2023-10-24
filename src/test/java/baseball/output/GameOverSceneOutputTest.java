package baseball.output;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.PrintOutputTest;
import baseball.game.GameConstants;
import org.junit.jupiter.api.Test;

public class GameOverSceneOutputTest extends PrintOutputTest {
    @Test
    void 숫자_입력_메시지_출력() {
        final GameOverSceneOutput gameOverSceneOutput = new GameOverSceneOutput();
        gameOverSceneOutput.printEndMessage();
        assertThat(output()).contains(
                GameConstants.SIZE_RANDOM_NUMBER + "개의 숫자를 모두 맞히셨습니다! 게임 종료\n"
                + "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."
        );
    }

    public void runMain() {
        // Empty
    }
}
