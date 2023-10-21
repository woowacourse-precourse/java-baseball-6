package baseball.balls;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BallValueEqualsTest {

    @Test
    void BallValue_동등성_true() {
        // given
        BallValue ballValue1 = new BallValue(1);
        BallValue ballValue2 = new BallValue(1);

        // when
        boolean isEquals = ballValue1.equals(ballValue2);

        // then
        Assertions.assertTrue(isEquals);
    }

    @Test
    void BallValue_해시_일치() {
        // given
        BallValue ballValue1 = new BallValue(1);
        BallValue ballValue2 = new BallValue(1);

        // when
        int hashCode1 = ballValue1.hashCode();
        int hashCode2 = ballValue2.hashCode();

        // then
        Assertions.assertEquals(hashCode1, hashCode2);
    }

    @Test
    void BallValue_동등성_false() {
        // given
        BallValue ballValue1 = new BallValue(1);
        BallValue ballValue2 = new BallValue(2);

        // when
        boolean isEquals = ballValue1.equals(ballValue2);

        // then
        Assertions.assertFalse(isEquals);
    }

    @Test
    void BallValue_해시_불일치() {
        // given
        BallValue ballValue1 = new BallValue(1);
        BallValue ballValue2 = new BallValue(2);

        // when
        int hashCode1 = ballValue1.hashCode();
        int hashCode2 = ballValue2.hashCode();

        // then
        Assertions.assertNotEquals(hashCode1, hashCode2);
    }

}
