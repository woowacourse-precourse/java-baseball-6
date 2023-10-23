package baseball.gameutil;

import baseball.gameutil.strgenerator.ResultStringGenerator;
import baseball.gameutil.strgenerator.ResultStringGeneratorBaseBall;
import baseball.message.MessageString;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

public class ResultStringGeneratorBaseBallTest {

    ResultStringGenerator resultStringGenerator = new ResultStringGeneratorBaseBall();

    enum TestCase {
        낫씽(0, 0, MessageString.NOTHING_MSG),
        원_볼(1, 0, "1볼"),
        원_볼_원_스트라이크(1, 1, "1볼 1스트라이크"),
        투_볼(2, 0, "2볼"),
        투볼_원_스트라이크(2, 1, "2볼 1스트라이크"),
        쓰리_볼(3, 0, "3볼"),
        원_스트라이크(0, 1, "1스트라이크"),
        투_스트라이크(0, 2, "2스트라이크"),
        쓰리_스트라이크(0, 3, "3스트라이크");

        int strike, ball;
        String expectedString;

        TestCase(int ball, int strike, String expectedString) {
            this.ball = ball;
            this.strike = strike;
            this.expectedString = expectedString;
        }
    }

    @ParameterizedTest
    @EnumSource(TestCase.class)
    void 점수계산(TestCase test) {
        // given
        Score score = new Score(test.ball, test.strike);

        //when
        String result = resultStringGenerator.result(score);

        // then

        Assertions.assertEquals(test.expectedString, result);
    }
}
