package baseball.game.enums;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class BaseballGameStatusTest {

    @Test
    void RUNNING인_상태에서_isRunning시_TRUE() {
        Assertions.assertThat(BaseballGameStatus.RUNNING.isRunning()).isTrue();
    }

    @Test
    void STOP인_상태에서_isRunning시_FALSE() {
        Assertions.assertThat(BaseballGameStatus.STOP.isRunning()).isFalse();
    }

}