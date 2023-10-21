package baseball.model;

import java.util.HashSet;
import java.util.LinkedHashSet;
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
    @Test
    public void BaLL_SET_ORDER_TEST() {
        Set<Ball> balls = new LinkedHashSet<>();
        for(int i = 0 ;i < 10 ; i++) {
            balls.add(new Ball(i));
        }
        int index = 0 ;
        for(Ball ball : balls) {
            Assertions.assertEquals(index,ball.getNumber());
            index++;
        }
    }

}