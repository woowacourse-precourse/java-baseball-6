package baseball.gameutil;

import baseball.gameutil.calculator.ScoreCalculator;
import baseball.gameutil.calculator.ScoreCalculatorBaseBall;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

public class ScoreCalculatorBaseBallTest {

    ScoreCalculator scoreCalculator = new ScoreCalculatorBaseBall();

    enum TestCase {
        낫씽(
            List.of(4, 5, 6),
            List.of(1, 2, 3),
            0,
            0
        ),
        원볼(
            List.of(3, 4, 5),
            List.of(1, 2, 3),
            1,
            0
        ),
        원볼_원스트라이크(
            List.of(3, 2, 5),
            List.of(1, 2, 3),
            1,
            1
        ),
        투볼(
            List.of(5, 3, 2),
            List.of(1, 2, 3),
            2,
            0
        ),
        투볼_원스트라이크(
            List.of(1, 3, 2),
            List.of(1, 2, 3),
            2,
            1
        ),
        쓰리볼(
            List.of(3, 1, 2),
            List.of(1, 2, 3),
            3,
            0
        ),
        원스트라이크(List.of(1, 4, 5),
            List.of(1, 2, 3),
            0,
            1
        ),
        투스트라이크(List.of(1, 2, 5),
            List.of(1, 2, 3),
            0,
            2
        ),
        쓰리스트라이크(List.of(1, 2, 3),
            List.of(1, 2, 3),
            0,
            3
        );

        List<Integer> userInput;
        List<Integer> computerInput;
        int expectedBall;
        int expectedStrike;

        TestCase(List<Integer> userInput, List<Integer> computerInput, int expectedBall,
            int expectedStrike) {
            this.userInput = userInput;
            this.computerInput = computerInput;
            this.expectedBall = expectedBall;
            this.expectedStrike = expectedStrike;
        }
    }

    @ParameterizedTest
    @EnumSource(TestCase.class)
    void 테스트(TestCase test) {
        //given
        List<Integer> userInput = test.userInput;
        List<Integer> computerInput = test.computerInput;

        //when
        Score score = scoreCalculator.calScore(userInput, computerInput);

        //then
        Assertions.assertEquals(test.expectedBall, score.getBall());
        Assertions.assertEquals(test.expectedStrike, score.getStrike());
    }

}
