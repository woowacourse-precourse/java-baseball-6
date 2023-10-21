package baseball.balls;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BallIndexEqualsTest {

    @Test
    void BallIndex_동등성_true() {
        // given
        BallIndex ballIndex1 = new BallIndex(1);
        BallIndex ballIndex2 = new BallIndex(1);

        // when
        boolean isEquals = ballIndex1.equals(ballIndex2);

        // then
        Assertions.assertTrue(isEquals);
    }

    @Test
    void BallIndex_해시_일치() {
        // given
        BallIndex ballIndex1 = new BallIndex(1);
        BallIndex ballIndex2 = new BallIndex(1);

        // when
        int hashCode1 = ballIndex1.hashCode();
        int hashCode2 = ballIndex2.hashCode();

        // then
        Assertions.assertEquals(hashCode1, hashCode2);
    }

    @Test
    void BallIndex_동등성_false() {
        // given
        BallIndex ballIndex1 = new BallIndex(1);
        BallIndex ballIndex2 = new BallIndex(2);

        // when
        boolean isEquals = ballIndex1.equals(ballIndex2);

        // then
        Assertions.assertFalse(isEquals);
    }

    @Test
    void BallIndex_해시_불일치() {
        // given
        BallIndex ballIndex1 = new BallIndex(1);
        BallIndex ballIndex2 = new BallIndex(2);

        // when
        int hashCode1 = ballIndex1.hashCode();
        int hashCode2 = ballIndex2.hashCode();

        // then
        Assertions.assertNotEquals(hashCode1, hashCode2);
    }

}
