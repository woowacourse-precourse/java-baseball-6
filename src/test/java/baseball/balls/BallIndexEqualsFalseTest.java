package baseball.balls;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BallIndexEqualsFalseTest {

    private BallIndex ballIndex1;
    private BallIndex ballIndex2;

    @BeforeEach
    void setup() {
        ballIndex1 = new BallIndex(1);
        ballIndex2 = new BallIndex(2);
    }

    @Test
    void BallIndex_동등성_false() {
        // when
        boolean isEquals = ballIndex1.equals(ballIndex2);

        // then
        Assertions.assertFalse(isEquals);
    }

    @Test
    void BallIndex_해시_불일치() {
        // when
        int hashCode1 = ballIndex1.hashCode();
        int hashCode2 = ballIndex2.hashCode();

        // then
        Assertions.assertNotEquals(hashCode1, hashCode2);
    }

}
