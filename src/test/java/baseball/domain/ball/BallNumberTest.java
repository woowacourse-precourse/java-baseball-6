package baseball.domain.ball;

import baseball.domain.ball.ballcomponent.BallNumber;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BallNumberTest {

    @Test
    @DisplayName("볼의 숫자가 같으면 True 를 반환한다.")
    void ballNumberTest1() {
        BallNumber ballNumber_1 = new BallNumber(7);
        BallNumber ballNumber_2 = new BallNumber(7);
        Assertions.assertThat(ballNumber_1.isSameNumber(ballNumber_2)).isTrue();
    }

    @Test
    @DisplayName("볼의 숫자가 다르면 False 를 반환한다.")
    void ballNumberTest2() {
        BallNumber ballNumber_1 = new BallNumber(7);
        BallNumber ballNumber_2 = new BallNumber(8);
        Assertions.assertThat(ballNumber_1.isSameNumber(ballNumber_2)).isFalse();
    }
}
