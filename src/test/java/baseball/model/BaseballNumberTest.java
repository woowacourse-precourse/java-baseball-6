package baseball.model;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BaseballNumberTest {

    @Test
    void compareTest() {
        BaseballNumber baseballNumber1 = new BaseballNumber(List.of(new BallNumber(1), new BallNumber(2), new BallNumber(3)));
        BaseballNumber baseballNumber2 = new BaseballNumber(List.of(new BallNumber(4), new BallNumber(5), new BallNumber(6)));
        BaseballNumber baseballNumber2_1b_1s = new BaseballNumber(List.of(new BallNumber(4), new BallNumber(6), new BallNumber(7)));

        Result resultNothing = baseballNumber1.compare(baseballNumber2);
        assertEquals(resultNothing.getResult(), "낫싱");

        Result result1b1s = baseballNumber2.compare(baseballNumber2_1b_1s);
        assertEquals(result1b1s.getResult(), "1볼 1스트라이크");
    }

}