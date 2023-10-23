package baseball.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BaseBallNumberTest {

    @DisplayName("3자리 모두 같은 숫자면 0볼 3스트라이크")
    @Test
    void compareNumber_allStrike() {
        //given
        BaseBallNumber num = new BaseBallNumber(1, 2, 3);
        BaseBallNumber num2 = new BaseBallNumber(1, 2, 3);

        //when
        BaseBallResult result = num.compareNumber(num2);

        //then
        assertThat(result.ball()).isEqualTo(0);
        assertThat(result.strike()).isEqualTo(3);
    }

    @DisplayName("3자리 모두 다른 위치의 숫자면 3볼 0스트라이크")
    @Test
    void compareNumber_allBall() {
        //given
        BaseBallNumber num = new BaseBallNumber(1, 2, 3);
        BaseBallNumber num2 = new BaseBallNumber(2, 3, 1);

        //when
        BaseBallResult result = num.compareNumber(num2);

        //then
        assertThat(result.ball()).isEqualTo(3);
        assertThat(result.strike()).isEqualTo(0);
    }

    @DisplayName("볼과 스트라이크 모두 있는 경우")
    @Test
    void compareNumber_strikeAndBall() {
        //given
        BaseBallNumber num = new BaseBallNumber(1, 2, 3);
        BaseBallNumber num2 = new BaseBallNumber(1, 3, 2);

        //when
        BaseBallResult result = num.compareNumber(num2);

        //then
        assertThat(result.ball()).isEqualTo(2);
        assertThat(result.strike()).isEqualTo(1);
    }

    @DisplayName("볼과 스트라이크 하나도 없으면 둘 다 0")
    @Test
    void compareNumber_allDiff() {
        //given
        BaseBallNumber num = new BaseBallNumber(1, 2, 3);
        BaseBallNumber num2 = new BaseBallNumber(4, 5, 6);

        //when
        BaseBallResult result = num.compareNumber(num2);

        //then
        assertThat(result.ball()).isEqualTo(0);
        assertThat(result.strike()).isEqualTo(0);
    }
}