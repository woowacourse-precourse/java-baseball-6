package baseball.game.enums;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class BaseballGameRestartsTest {

    @Test
    void find에_입력값1을_전달하면_재시작() {
        int inputNumber = 1;
        BaseballGameRestarts expected = BaseballGameRestarts.GAME_RESTART;

        BaseballGameRestarts restarts = BaseballGameRestarts.find(inputNumber);

        assertThat(restarts).isEqualTo(expected);
    }

    @Test
    void find에_입력값2을_전달하면_종료() {
        int inputNumber = 2;
        BaseballGameRestarts expected = BaseballGameRestarts.GAME_FINISH;

        BaseballGameRestarts restarts = BaseballGameRestarts.find(inputNumber);

        assertThat(restarts).isEqualTo(expected);
    }

    @Test
    void 입력값1를넣고_조회된값을_wantToFinish에_전달하면_FALSE() {
        int inputNumber = 1;
        BaseballGameRestarts expected = BaseballGameRestarts.GAME_RESTART;

        BaseballGameRestarts restarts = BaseballGameRestarts.find(inputNumber);

        assertThat(restarts.wantToFinish()).isFalse();
    }

    @Test
    void 입력값2를넣고_조회된값을_wantToFinish에_전달하면_TRUE() {
        int inputNumber = 2;
        BaseballGameRestarts expected = BaseballGameRestarts.GAME_FINISH;

        BaseballGameRestarts restarts = BaseballGameRestarts.find(inputNumber);

        assertThat(restarts.wantToFinish()).isTrue();
    }

}