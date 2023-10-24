package baseball.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BallsTest {

    @DisplayName("Ball 객체끼리의 동등성을 비교한다")
    @Test
    void equals() {
        Balls ball = new Balls(0, 0);
        Balls actual = new Balls(0, 0);
        Balls expectedFail = new Balls(0,1);
        Assertions.assertAll(
                () -> Assertions.assertEquals(ball, actual),
                () -> Assertions.assertNotEquals(expectedFail,actual)
        );
    }
}
