package baseball.utility;

import baseball.domain.balls.Ball;
import baseball.domain.balls.Balls;
import java.util.List;
import java.util.stream.IntStream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ConvertorUtilsTest {

    @Test
    void 문자열_Integer_리스트_변환_성공() {
        // given
        String string = "123";
        int ballCount = 3;

        // when
        List<Integer> integers = ConvertorUtils.convertStringToIntegerList(string);

        // then
        IntStream.range(0, ballCount)
                .forEach(i -> {
                    int value = integers.get(i);
                    int expectedValue = string.charAt(i) - '0';

                    Assertions.assertEquals(value, expectedValue);
                });
    }

    @Test
    void 문자열_Balls_변환_성공() {
        // given
        String string = "123";
        Ball ball1 = new Ball(1, 0);
        Ball ball2 = new Ball(2, 1);
        Ball ball3 = new Ball(3, 2);
        Ball ball4 = new Ball(4, 2);

        // when
        Balls balls = ConvertorUtils.convertStringToBalls(string);
        boolean hasBall1 = balls.hasSameBall(ball1);
        boolean hasBall2 = balls.hasSameBall(ball2);
        boolean hasBall3 = balls.hasSameBall(ball3);
        boolean hasBall4 = balls.hasSameBall(ball4);

        // then
        Assertions.assertTrue(hasBall1);
        Assertions.assertTrue(hasBall2);
        Assertions.assertTrue(hasBall3);
        Assertions.assertFalse(hasBall4);
    }

}
