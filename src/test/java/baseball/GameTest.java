package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.game.GameInput;
import baseball.game.GameOutput;
import baseball.game.GameUtil;
import baseball.game.impl.GameInputImpl;
import baseball.game.impl.GameOutputImpl;
import baseball.game.impl.GameUtilImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GameTest {

    @Test
    @DisplayName("입력에 따른 게임 종료 여부 확인")
    void replayTest() {
        GameInput gameInput = new GameInputImpl();
        GameOutput gameOutput = new GameOutputImpl();
        GameUtil gameUtil = new GameUtilImpl();

        Game game = new Game(gameInput, gameOutput, gameUtil);
        boolean result = game.replay("1");
        boolean result2 = game.replay("2");

        assertThat(result).isTrue();
        assertThat(result2).isFalse();
    }
}