package baseball.model;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BallTest {

    @Test
    public void BaLL_SET_TEST() {
        int onlyBall = 1 ;
        Set<Ball> balls = new HashSet<>();
        int testDuplicateNumber1 = 1;
        balls.add(new Ball(testDuplicateNumber1));
        int testDuplicateNumber2 = 1;
        balls.add(new Ball(testDuplicateNumber2));
        Assertions.assertEquals(onlyBall,balls.size());
    }

}