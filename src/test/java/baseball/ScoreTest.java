package baseball;

import static baseball.Score.NOTHING;
import static baseball.Score.ONE_BALL;
import static baseball.Score.ONE_BALL_ONE_STRIKE;
import static baseball.Score.ONE_STRIKE;
import static baseball.Score.THREE_STRIKE;
import static baseball.Score.TWO_BALL;
import static baseball.Score.TWO_BALL_ONE_STRIKE;
import static baseball.Score.TWO_STRIKE;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ScoreTest {

    @Test
    @DisplayName("0볼 + 0스트라이크 으로 NOTHING을 만든다.")
    void make_nothing() {
        // given // when
        Score result = Score.toScore(0, 0);

        // then
        assertThat(result).isEqualTo(NOTHING);
    }

    @Test
    @DisplayName("1볼 + 0스트라이크 으로 ONE_BALL을 만든다.")
    void make_one_ball() {
        // given // when
        Score result = Score.toScore(1, 0);

        // then
        assertThat(result).isEqualTo(ONE_BALL);
    }

    @Test
    @DisplayName("1볼 + 1스트라이크 으로 ONE_BALL_ONE_STRIKE를 만든다.")
    void make_one_ball_one_strike() {
        // given // when
        Score result = Score.toScore(1, 1);

        // then
        assertThat(result).isEqualTo(ONE_BALL_ONE_STRIKE);
    }

    @Test
    @DisplayName("2볼 + 0스트라이크 으로 TWO_BALL를 만든다.")
    void make_two_ball() {
        // given // when
        Score result = Score.toScore(2, 0);

        // then
        assertThat(result).isEqualTo(TWO_BALL);
    }

    @Test
    @DisplayName("2볼 + 1스트라이크 으로 TWO_BALL_ONE_STRIKE를 만든다.")
    void make_two_ball_one_strike() {
        // given // when
        Score result = Score.toScore(2, 1);

        // then
        assertThat(result).isEqualTo(TWO_BALL_ONE_STRIKE);
    }

    @Test
    @DisplayName("0볼 + 3스트라이크 으로 THREE_STRIKE를 만든다.")
    void make_three_strike() {
        // given // when
        Score result = Score.toScore(0, 3);

        // then
        assertThat(result).isEqualTo(THREE_STRIKE);
    }

    @Test
    @DisplayName("0볼 + 1스트라이크 으로 ONE_STRIKE를 만든다.")
    void make_one_strike() {
        // given // when
        Score result = Score.toScore(0, 1);

        // then
        assertThat(result).isEqualTo(ONE_STRIKE);
    }

    @Test
    @DisplayName("0볼 + 2스트라이크 으로 TWO_STRIKE를 만든다.")
    void make_two_strike() {
        // given // when
        Score result = Score.toScore(0, 2);

        // then
        assertThat(result).isEqualTo(TWO_STRIKE);
    }

}