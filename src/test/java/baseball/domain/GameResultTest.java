package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class GameResultTest {

    @DisplayName("0~3 사이가 아닌 숫자가 스트라이크를 수정할 경우 예외가 발생한다.")
    @Test
    void setStrike() {
        // given
        GameResult gameResult = new GameResult();
        int strike = 4;

        // when, then
        assertThatThrownBy(() -> gameResult.setStrike(strike))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("0~3 사이가 아닌 숫자가 볼을 수정할 경우 예외가 발생한다.")
    @Test
    void setBall() {
        // given
        GameResult gameResult = new GameResult();
        int ball = -1;

        // when, then
        assertThatThrownBy(() -> gameResult.setBall(ball))
                .isInstanceOf(IllegalArgumentException.class);
    }

}