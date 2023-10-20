package baseball.balls;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BallValueEqualsTrueTest {

    private BallValue ballValue1;
    private BallValue ballValue2;

    @BeforeEach
    void setup() {
        ballValue1 = new BallValue(1);
        ballValue2 = new BallValue(1);
    }

    @Test
    void BallValue_동등성_true() {
        // when
        boolean isEquals = ballValue1.equals(ballValue2);

        // then
        Assertions.assertTrue(isEquals);
    }

    @Test
    void BallValue_해시_일치() {
        // when
        int hashCode1 = ballValue1.hashCode();
        int hashCode2 = ballValue2.hashCode();

        // then
        Assertions.assertEquals(hashCode1, hashCode2);
    }

}
