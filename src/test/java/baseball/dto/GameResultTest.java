package baseball.dto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class GameResultTest {
    @Test
    @DisplayName("올바른 입력으로 생성")
    void createdByValidInput() {
        int strike = 1;
        int ball = 1;

        GameResult gameResult = new GameResult(strike, ball);

        assertThat(gameResult).isNotNull();
    }

    @Nested
    @DisplayName("잘못된 개수의")
    class createdByInvalidStrikeOrBall {
        @Test
        @DisplayName("스트라이크로 생성")
        void createdByInvalidStrike() {
            int strike = 4;
            int ball = 1;

            assertThrows(IllegalStateException.class, () -> new GameResult(strike, ball));
        }

        @Test
        @DisplayName("볼로 생성")
        void createdByInvalidBall() {
            int strike = 1;
            int ball = 4;

            assertThrows(IllegalStateException.class, () -> new GameResult(strike, ball));
        }
    }

    @Test
    @DisplayName("스트라이크가 3개면 성공")
    void isClearWhenStrikeIsThree() {
        int strike = 3;
        int ball = 0;

        GameResult gameResult = new GameResult(strike, ball);
        boolean isClear = gameResult.isClear();

        assertThat(isClear).isTrue();
    }

    @Test
    @DisplayName("스트라이크가 3개 미만이면 실패")
    void isNotClearWhenStrikeIsNotThree() {
        int strike = 2;
        int ball = 1;

        GameResult gameResult = new GameResult(strike, ball);
        boolean isClear = gameResult.isClear();

        assertThat(isClear).isFalse();
    }
}