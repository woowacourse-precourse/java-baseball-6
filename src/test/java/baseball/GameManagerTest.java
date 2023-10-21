package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class GameManagerTest extends NsTest {

    private boolean nextGameState;

    @Test
    void 다음게임을_진행하려고_1을_누르면_false를_반환합니다() {
        run("1");
        assertThat(nextGameState).isFalse();
    }

    @Test
    void 게임을_중단하려고_2를_누르면_true를_반환합니다() {
        run("2");
        assertThat(nextGameState).isTrue();
    }

    @Test
    void 입력값이_1과2_이외의_수이면_예외가_발생합니다() {
        assertThatThrownBy(() -> run("0"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> run("3"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Override
    public void runMain() {
        GameManager gameManager = GameManager.initGame();
        nextGameState = gameManager.getNextGameState();
    }
}