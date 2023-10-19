package baseball.domain.ball;

import baseball.domain.result.BallResult;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BallTest {

    @Test
    @DisplayName("볼의 숫자, 위치가 같은 볼을 비교하면 스트라이크를 반환한다.")
    void ballTest1() {
        Ball ball1 = new Ball(1, 2);
        Ball ball2 = new Ball(1, 2);
        BallResult ballResult = ball1.compareBall(ball2);
        Assertions.assertThat(ballResult).isEqualTo(BallResult.STRIKE);
    }

    @Test
    @DisplayName("볼의 숫자는 같지만 위치가 다르면 볼을 반환한다.")
    void ballTest2() {
        Ball ball1 = new Ball(1, 2);
        Ball ball2 = new Ball(1, 1);
        BallResult ballResult = ball1.compareBall(ball2);
        Assertions.assertThat(ballResult).isEqualTo(BallResult.BALL);
    }

    @Test
    @DisplayName("볼의 위치는같지만 숫자가 다르면 낫띵을 반환한다.")
    void ballTest3() {
        Ball ball1 = new Ball(1, 2);
        Ball ball2 = new Ball(2, 2);
        BallResult ballResult = ball1.compareBall(ball2);
        Assertions.assertThat(ballResult).isEqualTo(BallResult.NOTHING);
    }

    @Test
    @DisplayName("볼의 위치와 숫자가 다르면 낫띵을 반환한다.")
    void ballTest4() {
        Ball ball1 = new Ball(1, 2);
        Ball ball2 = new Ball(2, 3);
        BallResult ballResult = ball1.compareBall(ball2);
        Assertions.assertThat(ballResult).isEqualTo(BallResult.NOTHING);
    }
}
