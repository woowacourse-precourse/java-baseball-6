package baseball.balls;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BallEqualsFalseTest {

    private Ball ball1;
    private BallIndex ballIndex1;
    private BallValue ballValue1;

    private Ball ball2;
    private BallIndex ballIndex2;
    private BallValue ballValue2;

    @BeforeEach
    void setup() {
        ballValue1 = new BallValue(1);
        ballValue2 = new BallValue(2);

        ballIndex1 = new BallIndex(1);
        ballIndex2 = new BallIndex(2);

        ball1 = new Ball(ballValue1, ballIndex1);
        ball2 = new Ball(ballValue2, ballIndex2);
    }

    @Test
    void Ball_동등성_false() {
        // when
        boolean isEquals = ball1.equals(ball2);

        // then
        Assertions.assertFalse(isEquals);
    }

    @Test
    void Ball_해시_불일치() {
        // when
        int hashCode1 = ball1.hashCode();
        int hashCode2 = ball2.hashCode();

        // then
        Assertions.assertNotEquals(hashCode1, hashCode2);
    }

    @Test
    void Ball_다른_값() {
        // when
        boolean hasSameValue = ball1.hasSameValue(ball2);

        // then
        Assertions.assertFalse(hasSameValue);
    }

    @Test
    void Ball_다른_위치() {
        // when
        boolean hasSameIndex = ball1.hasSameIndex(ball2);

        // then
        Assertions.assertFalse(hasSameIndex);
    }

}
