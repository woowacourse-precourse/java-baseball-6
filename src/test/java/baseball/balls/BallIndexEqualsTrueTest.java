package baseball.balls;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BallIndexEqualsTrueTest {

    private BallIndex ballIndex1;
    private BallIndex ballIndex2;

    @BeforeEach
    void setup() {
        ballIndex1 = new BallIndex(1);
        ballIndex2 = new BallIndex(1);
    }

    @Test
    void BallIndex_동등성_true() {
        // when
        boolean isEquals = ballIndex1.equals(ballIndex2);

        // then
        Assertions.assertTrue(isEquals);
    }

    @Test
    void BallIndex_해시_일치() {
        // when
        int hashCode1 = ballIndex1.hashCode();
        int hashCode2 = ballIndex2.hashCode();

        // then
        Assertions.assertEquals(hashCode1, hashCode2);
    }

}
