package baseball.model;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BallNumbersTest {

    @Test
    void compareTest() {
        BallNumbers ballNumbers1 = new BallNumbers(List.of(new Ball(1), new Ball(2), new Ball(3)));
        BallNumbers ballNumbers2 = new BallNumbers(List.of(new Ball(4), new Ball(5), new Ball(6)));
        BallNumbers ballNumbers2_1B_1S = new BallNumbers(List.of(new Ball(4), new Ball(6), new Ball(7)));

        Result resultNothing = ballNumbers1.compare(ballNumbers2);
        assertEquals(resultNothing.getResult(), "낫싱");

        Result result1b1s = ballNumbers2.compare(ballNumbers2_1B_1S);
        assertEquals(result1b1s.getResult(), "1볼 1스트라이크");
    }

}