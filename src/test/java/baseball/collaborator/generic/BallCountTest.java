package baseball.collaborator.generic;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class BallCountTest {

    @Test
    void 스트라이크_음수카운팅_시도_시_예외가_발생하는지() {
        long strike = -1L;
        long ball = 4L;

        assertThatThrownBy(() -> new BallCount(strike, ball))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith("잘못된 볼카운팅");
    }

    @Test
    void 볼_음수카운팅_시도_시_예외가_발생하는지() {
        long strike = 4L;
        long ball = -1L;

        assertThatThrownBy(() -> new BallCount(strike, ball))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith("잘못된 볼카운팅");
    }

    @Test
    void 너무많은_카운팅_시도_시_예외가_발생하는지() {
        long strike = 1L;
        long ball = 3L;

        assertThatThrownBy(() -> new BallCount(strike, ball))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith("잘못된 볼카운팅");
    }

    @Test
    void 스트라이크가_3개_미만일때_isFullCount가_false() {
        long nowStrike = 2L;
        long nowBall = 1L;

        BallCount ballCount = new BallCount(nowStrike, nowBall);
        boolean result = ballCount.isFullCount();

        assertThat(result).isFalse();
    }

    @Test
    void 스트라이크가_3개일때_isFullCount가_true() {
        long nowStrike = 3L;
        long nowBall = 0L;

        BallCount ballCount = new BallCount(nowStrike, nowBall);
        boolean result = ballCount.isFullCount();

        assertThat(result).isTrue();
    }

    @Test
    void 볼만_있을때의_toString시_볼만_출력되어야함() {
        String message = "3볼";

        BallCount ballCount = new BallCount(0L, 3L);

        assertThat(ballCount.toString()).isEqualTo(message);
    }

    @Test
    void 스트라이크만_있을때의_toString시_볼만_출력되어야함() {
        String message = "3스트라이크";

        BallCount ballCount = new BallCount(3L, 0L);

        assertThat(ballCount.toString()).isEqualTo(message);
    }

    @Test
    void 스트라이크와_볼이_모두_있을때_toString시_볼_공백_스트라이크_순으로_출력되어야함() {
        String message = "1볼 2스트라이크";

        BallCount ballCount = new BallCount(2L, 1L);

        assertThat(ballCount.toString()).isEqualTo(message);
    }

    @Test
    void strike의_갯수가_정상적으로_가져와지는지() {
        long strike = 2L;
        long ball = 1L;

        BallCount ballCount = new BallCount(strike, ball);

        assertThat(ballCount.countOfStrike()).isEqualTo(strike);
    }

    @Test
    void ball의_갯수가_정상적으로_가져와지는지() {
        long strike = 2L;
        long ball = 1L;

        BallCount ballCount = new BallCount(strike, ball);

        assertThat(ballCount.countOfBall()).isEqualTo(ball);
    }

}