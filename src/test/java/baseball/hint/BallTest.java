package baseball.hint;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BallTest {
    @Test
    void 볼_개수_확인() {
        Ball ball = new Ball();
        Strike strike = new Strike();

        List<Integer> randomNumber = new ArrayList<>(Arrays.asList(1, 2, 3));
        List<Integer> userNumber = new ArrayList<>(Arrays.asList(3, 2, 1));

        int ballCount = ball.compare(randomNumber, userNumber) - strike.compare(randomNumber, userNumber);

        assertEquals(2, ballCount);
    }
}