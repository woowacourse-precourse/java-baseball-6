package baseball;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;

public class BallsTest {

    @Test
    void ballsSizeTest() {
        List<Ball> ballList = List.of(new Ball(1, 1), new Ball(1, 2));
        Balls balls = new Balls(ballList);
        assertThatThrownBy(() -> balls.validateSize(ballList))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("3자리의 숫자를 입력해주세요.");
    }

    @Test
    void ballHasDuplicates() {
        List<Ball> ballList = List.of(new Ball(1, 1), new Ball(1, 1), new Ball(1, 2));
        Balls balls = new Balls(ballList);
        assertThatThrownBy(() -> balls.valdateDuplicates(ballList))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("중복되지 않는 3자리의 숫자를 입력해주세요.");

    }

    @Test
    void 정답은_1_입력숫자도1일때_true를_반환한다() {
        Ball ball = new Ball(1, 1);
        Ball otherBall = new Ball(1, 1);
        assertThat(ball.equals(otherBall)).isTrue();
    }

    @Test
    void 정답은_1_입력숫자는_2일때_첫째자리_비교결과_false를_반환한다() {
        Ball ball = new Ball(1, 1);
        Ball otherBall = new Ball(1, 2);
        assertThat(ball.equals(otherBall)).isFalse();
    }
    @Test
    void 정답은_1_입력숫자는_1일때_첫째자리_비교결과_true를_반환한다() {
        Ball ball = new Ball(1, 1);
        Ball otherBall = new Ball(1, 1);
        assertThat(ball.equals(otherBall)).isTrue();
    }

    @Test
    void 정답은_123_입력숫자는_123일때_strike_3를_반환한다() {
        Balls balls = new Balls(new Ball(1,1), new Ball(2,2), new Ball(3,3));
        Balls otherBalls = new Balls(new Ball(1,1), new Ball(2,2), new Ball(3,3));
        assertThat(balls.getStrikeCount(otherBalls)).isEqualTo(3);
    }
    @Test
    void 정답은_123_입력숫자는_321일때_strike_1를_반환한다() {
        Balls balls = new Balls(new Ball(1,1), new Ball(2,2), new Ball(3,3));
        Balls otherBalls = new Balls(new Ball(1,3), new Ball(2,2), new Ball(3,1));
        assertThat(balls.getStrikeCount(otherBalls)).isEqualTo(1);
    }
}
