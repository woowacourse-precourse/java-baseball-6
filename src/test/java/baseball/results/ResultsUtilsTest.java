package baseball.results;

import baseball.balls.Ball;
import baseball.balls.Balls;
import baseball.utils.ResultsUtils;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ResultsUtilsTest {

    private Balls balls;

    @BeforeEach
    void setup() {
        List<Ball> balls = Arrays.asList(
                new Ball(1, 0),
                new Ball(2, 1),
                new Ball(3, 2)
        );
        this.balls = new Balls(balls);
    }

    @Test
    void 스트라이크_판정() {
        // given
        Ball ball = new Ball(1, 0);

        // when
        ResultStatus result = ResultsUtils.determineResultStatus(balls, ball);
        ResultStatus expectedResult = ResultStatus.STRIKE;

        // then
        Assertions.assertEquals(result, expectedResult);
    }

    @Test
    void 볼_판정() {
        // given
        Ball ball = new Ball(2, 0);

        // when
        ResultStatus result = ResultsUtils.determineResultStatus(balls, ball);
        ResultStatus expectedResult = ResultStatus.BALL;

        // then
        Assertions.assertEquals(result, expectedResult);
    }

    @Test
    void 아웃_판정() {
        // given
        Ball ball = new Ball(4, 0);

        // when
        ResultStatus result = ResultsUtils.determineResultStatus(balls, ball);
        ResultStatus expectedResult = ResultStatus.OUT;

        // then
        Assertions.assertEquals(result, expectedResult);
    }

}
