package baseball;

import org.junit.jupiter.api.Test;

import camp.nextstep.edu.missionutils.test.NsTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class GameConsoleTest extends NsTest {
    @Test
    void 게임_승리_후_재시작_후_종료() {
        assertSimpleTest(
                () -> {
                    run("1", "2");
                    assertThat(output()).contains("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                }
        );
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(
                () -> assertThatThrownBy(() -> runException("1234"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    class TestGame extends Game {
        @Override
        boolean initGame() {
            return false;
        }

        @Override
        void playGame() {}

    }

    @Override
    protected void runMain() {
        TestGame game = new TestGame();
        GameConsole.play(game);
    }
}
