package baseball.domain.ball;

import baseball.domain.result.BallResult;
import baseball.domain.result.GameResult;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BallsTest {

    private final Ball ball1 = new Ball(1, 0);
    private final Ball ball2 = new Ball(2, 1);
    private final Ball ball3 = new Ball(3, 2);
    private final Ball ballOnlyNumberSame1 = new Ball(3, 0);
    private final Ball ballDifferent1 = new Ball(4, 0);
    private final Ball ballDifferent2 = new Ball(5, 1);
    private final Ball ballDifferent3 = new Ball(6, 2);

    @Test
    @DisplayName("숫자, 위치가 동일한 Ball 을 Balls 와 비교하면 스트라이크가 나온다")
    void ballsTestWithBall_1() {
        Balls balls = new Balls(ball1, ball2, ball3);
        BallResult ballResult = balls.compareWithBall(ball1);
        Assertions.assertThat(ballResult).isEqualTo(BallResult.STRIKE);
    }

    @Test
    @DisplayName("숫자만 동일한 Ball 을 Balls 와 비교하면 볼이 나온다")
    void ballsTestWithBall_2() {
        Balls balls = new Balls(ball1, ball2, ball3);
        BallResult ballResult = balls.compareWithBall(ballOnlyNumberSame1);
        Assertions.assertThat(ballResult).isEqualTo(BallResult.BALL);
    }

    @Test
    @DisplayName("숫자가 다른 Ball 을 Balls 와 비교하면 스트라이크가 나온다")
    void ballsTestWithBall_3() {
        Balls balls = new Balls(ball1, ball2, ball3);
        BallResult ballResult = balls.compareWithBall(ballDifferent1);
        Assertions.assertThat(ballResult).isEqualTo(BallResult.NOTHING);
    }

    @Test
    @DisplayName("동일한 세개 Ball 을 가진 Balls 를 비교시 3 스트라이크가 나온다.")
    void ballsTestWithBalls_1() {
        Balls balls1 = new Balls(ball1, ball2, ball3);
        Balls balls2 = new Balls(ball1, ball2, ball3);
        GameResult gameResult = balls1.compareWithBalls(balls2);
        Assertions.assertThat(gameResult.getResult()).isEqualTo("3 스트라이크");
    }

    @Test
    @DisplayName("동일한 하나의 Ball 과 숫자만 동일한 하나의 Ball 을 가진 Balls 를 비교시 1 스트라이크 1볼 이 나온다.")
    void ballsTestWithBalls_2() {
        Balls balls1 = new Balls(ball1, ball2, ball3);
        Balls balls2 = new Balls(ballOnlyNumberSame1, ball2, ballDifferent3);
        GameResult gameResult = balls1.compareWithBalls(balls2);
        Assertions.assertThat(gameResult.getResult()).isEqualTo("1 스트라이크 1 볼");
    }

    @Test
    @DisplayName("숫자만 동일한 Ball 1개 를 가진 Balls 를 비교시 1 볼이 나온다.")
    void ballsTestWithBalls_3() {
        Balls balls1 = new Balls(ball1, ball2, ball3);
        Balls balls2 = new Balls(ballOnlyNumberSame1, ballDifferent2, ballDifferent3);
        GameResult gameResult = balls1.compareWithBalls(balls2);
        Assertions.assertThat(gameResult.getResult()).isEqualTo("1 볼");
    }

    @Test
    @DisplayName("완전히 다른 Ball 을 가진 Balls 를 비교시 낫띵 이 나온다.")
    void ballsTestWithBalls_4() {
        Balls balls1 = new Balls(ball1, ball2, ball3);
        Balls balls2 = new Balls(ballDifferent1, ballDifferent2, ballDifferent3);
        GameResult gameResult = balls1.compareWithBalls(balls2);
        Assertions.assertThat(gameResult.getResult()).isEqualTo("낫띵");
    }
}