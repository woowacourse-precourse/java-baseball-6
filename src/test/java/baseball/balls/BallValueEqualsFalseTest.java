package baseball.balls;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BallValueEqualsFalseTest {

    private BallValue ballValue1;
    private BallValue ballValue2;

    @BeforeEach
    void setup() {
        ballValue1 = new BallValue(1);
        ballValue2 = new BallValue(2);
    }

    @Test
    void BallValue_동등성_false() {
        // when
        boolean isEquals = ballValue1.equals(ballValue2);

        // then
        Assertions.assertFalse(isEquals);
    }

    @Test
    void BallValue_해시_불일치() {
        // when
        int hashCode1 = ballValue1.hashCode();
        int hashCode2 = ballValue2.hashCode();

        // then
        Assertions.assertNotEquals(hashCode1, hashCode2);
    }

}
