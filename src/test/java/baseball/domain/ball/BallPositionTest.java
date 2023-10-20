package baseball.domain.ball;

import baseball.domain.ball.ballcomponent.BallPosition;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BallPositionTest {

    @Test
    @DisplayName("볼의 위치가 같으면 True 반환, 다르면 False 반환")
    void ballPositionTest() {
        BallPosition ballPosition1 = new BallPosition(1);
        BallPosition ballPosition2 = new BallPosition(1);
        BallPosition ballPosition3 = new BallPosition(2);
        Assertions.assertThat(ballPosition1.isSamePosition(ballPosition2)).isTrue();
        Assertions.assertThat(ballPosition1.isSamePosition(ballPosition3)).isFalse();
    }
}
