package baseball.games.numberbaseball.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BallCountTest {

    @Test
    @DisplayName("스트라이크 값이 3이라면 true")
    void isThreeStrike() {
        //given
        BallCount ballCount = new BallCount(0, 3);
        //when
        boolean isThreeStrike = ballCount.isThreeStrike();
        //then
        assertThat(isThreeStrike).isTrue();
    }

    @Test
    @DisplayName("스트라이크 값이 3이 아니라면 false")
    void isNotThreeStrike() {
        //given
        BallCount ballCount = new BallCount(0, 2);
        //when
        boolean isThreeStrike = ballCount.isThreeStrike();
        //then
        assertThat(isThreeStrike).isFalse();
    }
}