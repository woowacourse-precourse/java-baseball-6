package baseball.domain.ball;

import baseball.domain.result.BallResult;
import baseball.domain.result.GameResult;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BallsTest {

    private final Ball ballSame = new Ball(1, 0);
    private final Ball ballOnlyNumberSame = new Ball(3, 0);
    private final Ball ballDifferent = new Ball(4, 0);
    private final Balls balls = new Balls(123);

    @Test
    @DisplayName("숫자, 위치가 동일한 Ball 을 Balls 와 비교하면 스트라이크가 나온다")
    void ballsTestWithBall_1() {
        BallResult ballResult = balls.compareWithBall(ballSame);
        Assertions.assertThat(ballResult).isEqualTo(BallResult.STRIKE);
    }

    @Test
    @DisplayName("숫자만 동일한 Ball 을 Balls 와 비교하면 볼이 나온다")
    void ballsTestWithBall_2() {
        BallResult ballResult = balls.compareWithBall(ballOnlyNumberSame);
        Assertions.assertThat(ballResult).isEqualTo(BallResult.BALL);
    }

    @Test
    @DisplayName("숫자가 다른 Ball 을 Balls 와 비교하면 스트라이크가 나온다")
    void ballsTestWithBall_3() {
        BallResult ballResult = balls.compareWithBall(ballDifferent);
        Assertions.assertThat(ballResult).isEqualTo(BallResult.NOTHING);
    }

    @Test
    @DisplayName("동일한 세개 Ball 을 가진 Balls 를 비교시 3 스트라이크가 나온다.")
    void ballsTestWithBalls_1() {
        Balls balls2 = new Balls(123);
        GameResult gameResult = balls.compareWithBalls(balls2);
        Assertions.assertThat(gameResult.getResult()).isEqualTo("3스트라이크");
    }

    @Test
    @DisplayName("동일한 하나의 Ball 과 숫자만 동일한 하나의 Ball 을 가진 Balls 를 비교시 1 스트라이크 1볼 이 나온다.")
    void ballsTestWithBalls_2() {
        Balls ballsToCompare = new Balls(325);
        GameResult gameResult = balls.compareWithBalls(ballsToCompare);
        Assertions.assertThat(gameResult.getResult()).isEqualTo("1볼 1스트라이크");
    }

    @Test
    @DisplayName("숫자만 동일한 Ball 1개 를 가진 Balls 를 비교시 1 볼이 나온다.")
    void ballsTestWithBalls_3() {
        Balls ballsToCompare = new Balls(345);
        GameResult gameResult = balls.compareWithBalls(ballsToCompare);
        Assertions.assertThat(gameResult.getResult()).isEqualTo("1볼");
    }

    @Test
    @DisplayName("완전히 다른 Ball 을 가진 Balls 를 비교시 낫띵 이 나온다.")
    void ballsTestWithBalls_4() {
        Balls ballsToCompare = new Balls(456);
        GameResult gameResult = balls.compareWithBalls(ballsToCompare);
        Assertions.assertThat(gameResult.getResult()).isEqualTo("낫싱");
    }

    @Test
    @DisplayName("두자리 숫자로 Balls 생성시 예외 발생")
    void exceptionTest_1() {
        Assertions.assertThatThrownBy(() -> new Balls(99)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("네자리 숫자로 Balls 생성시 예외 발생")
    void exceptionTest_2() {
        Assertions.assertThatThrownBy(() -> new Balls(1000)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("세자리 숫자로 Balls 생성시 예외 발생 하지 않는다. 경계값 테스트")
    void exceptionTest_3() {
        new Balls(123);
        new Balls(987);
    }
}