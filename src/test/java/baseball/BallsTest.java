package baseball;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;

public class BallsTest {

    @Test
    void _2자리_입력한_경우() {
        List<Integer> rawBallList = InputConvertor.convertBalls("12");
        assertThatThrownBy(() -> InputValidator.validateBallsCount(rawBallList))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("3자리의 숫자를 입력해주세요.");
    }
    @Test
    void _4자리_입력한_경우() {
        List<Integer> rawBallList = InputConvertor.convertBalls("1234");
        assertThatThrownBy(() -> InputValidator.validateBallsCount(rawBallList))
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
    void 정답은_123_입력숫자는_123일때_strike_3를_반환한다() {
        Balls balls = new Balls(new Ball(1,1), new Ball(2,2), new Ball(3,3));
        Balls otherBalls = new Balls(new Ball(1,1), new Ball(2,2), new Ball(3,3));
        assertThat(balls.getTryResultList(otherBalls)).containsExactly(TryResult.STRIKE, TryResult.STRIKE, TryResult.STRIKE);
    }
    @Test
    void 정답은_123_입력숫자는_231일때_ball_3를_반환한다() {
        Balls balls = new Balls(new Ball(1,1), new Ball(2,2), new Ball(3,3));
        Balls otherBalls = new Balls(new Ball(1,2), new Ball(2,3), new Ball(3,1));
        assertThat(balls.getTryResultList(otherBalls)).containsExactly(TryResult.BALL, TryResult.BALL, TryResult.BALL);
    }
    @Test
    void 정답은_123_입력숫자는_135일때_strike_1_ball_1를_반환한다() {
        Balls balls = new Balls(new Ball(1,1), new Ball(2,2), new Ball(3,3));
        Balls otherBalls = new Balls(new Ball(1,1), new Ball(2,3), new Ball(3,5));
        assertThat(balls.getTryResultList(otherBalls)).contains(TryResult.STRIKE, TryResult.BALL);
    }
}
