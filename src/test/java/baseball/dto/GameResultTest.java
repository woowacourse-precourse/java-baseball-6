package baseball.dto;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
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
}