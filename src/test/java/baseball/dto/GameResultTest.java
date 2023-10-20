package baseball.dto;

import static org.assertj.core.api.Assertions.assertThat;

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

    @Test
    @DisplayName("스트라이크와 볼이 모두 0개면 낫싱")
    void isNothingWhenBothStrikeAndBallIsZero() {
        int strike = 0;
        int ball = 0;

        GameResult gameResult = new GameResult(strike, ball);
        boolean isNothing = gameResult.isNothing();

        assertThat(isNothing).isTrue();
    }

    @Nested
    @DisplayName("낫싱이 아닌 상태에서")
    class isStrikeOrBallOnly {
        @Test
        @DisplayName("볼이 0개면 스트라이크 온리")
        void isStrikeOnlyWhenBallIsZero() {
            int strike = 2;
            int ball = 0;

            GameResult gameResult = new GameResult(strike, ball);
            boolean isStrikeOnly = gameResult.isStrikeOnly();

            assertThat(isStrikeOnly).isTrue();
        }

        @Test
        @DisplayName("스트라이크가 0개면 볼 온리")
        void isBallOnlyWhenStrikeIsZero() {
            int strike = 0;
            int ball = 2;

            GameResult gameResult = new GameResult(strike, ball);
            boolean isBallOnly = gameResult.isBallOnly();

            assertThat(isBallOnly).isTrue();
        }
    }
}