package baseball.domain.ball;

import baseball.domain.result.BallResult;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BallTest {

    private final Ball ball = new Ball(1, 2);
    private final Ball ballSame = new Ball(1, 2);
    private final Ball ballOnlyNumberSame = new Ball(1, 1);
    private final Ball ballOnlyPositionSame = new Ball(2, 2);
    private final Ball ballAllDifferent = new Ball(2, 1);


    @Test
    @DisplayName("볼의 숫자, 위치가 같은 볼을 비교하면 스트라이크를 반환한다.")
    void ballTest1() {
        BallResult ballResult = ball.compareBall(ballSame);
        Assertions.assertThat(ballResult).isEqualTo(BallResult.STRIKE);
    }

    @Test
    @DisplayName("볼의 숫자는 같지만 위치가 다르면 볼을 반환한다.")
    void ballTest2() {
        BallResult ballResult = ball.compareBall(ballOnlyNumberSame);
        Assertions.assertThat(ballResult).isEqualTo(BallResult.BALL);
    }

    @Test
    @DisplayName("볼의 위치는같지만 숫자가 다르면 낫띵을 반환한다.")
    void ballTest3() {
        BallResult ballResult = ball.compareBall(ballOnlyPositionSame);
        Assertions.assertThat(ballResult).isEqualTo(BallResult.NOTHING);
    }

    @Test
    @DisplayName("볼의 위치와 숫자가 다르면 낫띵을 반환한다.")
    void ballTest4() {
        BallResult ballResult = ball.compareBall(ballAllDifferent);
        Assertions.assertThat(ballResult).isEqualTo(BallResult.NOTHING);
    }
}
