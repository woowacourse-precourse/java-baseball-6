package baseball.balls;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BallEqualsTest {

    private Ball ball1;
    private Ball ball2;
    private Ball ball3;

    @BeforeEach
    void setup() {
        BallValue ballValue1 = new BallValue(1);
        BallValue ballValue2 = new BallValue(2);

        BallIndex ballIndex1 = new BallIndex(1);
        BallIndex ballIndex2 = new BallIndex(2);

        ball1 = new Ball(ballValue1, ballIndex1);
        ball2 = new Ball(ballValue1, ballIndex1);
        ball3 = new Ball(ballValue2, ballIndex2);
    }

    @Test
    void Ball_동등성_true() {
        // when
        boolean isEquals = ball1.equals(ball2);

        // then
        Assertions.assertTrue(isEquals);
    }

    @Test
    void Ball_해시_일치() {
        // when
        int hashCode1 = ball1.hashCode();
        int hashCode2 = ball2.hashCode();

        // then
        Assertions.assertEquals(hashCode1, hashCode2);
    }

    @Test
    void Ball_같은_값() {
        // when
        boolean hasSameValue = ball1.hasSameValue(ball2);

        // then
        Assertions.assertTrue(hasSameValue);
    }

    @Test
    void Ball_같은_인덱스() {
        // when
        boolean hasSameIndex = ball1.hasSameIndex(ball2);

        // then
        Assertions.assertTrue(hasSameIndex);
    }

    @Test
    void Ball_동등성_false() {
        // when
        boolean isEquals = ball1.equals(ball3);

        // then
        Assertions.assertFalse(isEquals);
    }

    @Test
    void Ball_해시_불일치() {
        // when
        int hashCode1 = ball1.hashCode();
        int hashCode3 = ball3.hashCode();

        // then
        Assertions.assertNotEquals(hashCode1, hashCode3);
    }

    @Test
    void Ball_다른_값() {
        // when
        boolean hasSameValue = ball1.hasSameValue(ball3);

        // then
        Assertions.assertFalse(hasSameValue);
    }

    @Test
    void Ball_다른_인덱스() {
        // when
        boolean hasSameIndex = ball1.hasSameIndex(ball3);

        // then
        Assertions.assertFalse(hasSameIndex);
    }

}
