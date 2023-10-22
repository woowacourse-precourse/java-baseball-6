package baseball.gameutil;

import baseball.message.MessageString;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ResultStringGeneratorBaseBallTest {
    @Test
    public void 낫_씽(){
        // given
        Score score = new Score(0, 0);
        ResultStringGenerator resultStringGenerator = new ResultStringGeneratorBaseBall();

        //when
        String result = resultStringGenerator.result(score);

        // then

        Assertions.assertEquals(MessageString.NOTHING_MSG, result);
    }

    @Test
    public void 원_볼() {
        // given
        Score score = new Score(1, 0);
        ResultStringGenerator resultStringGenerator = new ResultStringGeneratorBaseBall();

        //when
        String result = resultStringGenerator.result(score);

        // then

        Assertions.assertEquals("1볼", result);
    }

    @Test
    public void 원_볼_원_스트라이크() {
        // given
        Score score = new Score(1, 1);
        ResultStringGenerator resultStringGenerator = new ResultStringGeneratorBaseBall();

        //when
        String result = resultStringGenerator.result(score);

        // then

        Assertions.assertEquals("1볼 1스트라이크", result);
    }

    @Test
    public void 투_볼() {
        // given
        Score score = new Score(2, 0);
        ResultStringGenerator resultStringGenerator = new ResultStringGeneratorBaseBall();

        //when
        String result = resultStringGenerator.result(score);

        // then

        Assertions.assertEquals("2볼", result);
    }

    @Test
    public void 투_볼_원_스트라이크() {
        // given
        Score score = new Score(2, 1);
        ResultStringGenerator resultStringGenerator = new ResultStringGeneratorBaseBall();

        //when
        String result = resultStringGenerator.result(score);

        // then

        Assertions.assertEquals("2볼 1스트라이크", result);
    }

    @Test
    public void 쓰리_볼() {
        // given
        Score score = new Score(3, 0);
        ResultStringGenerator resultStringGenerator = new ResultStringGeneratorBaseBall();

        //when
        String result = resultStringGenerator.result(score);

        // then

        Assertions.assertEquals("3볼", result);
    }

    @Test
    public void 원_스트라이크() {
        // given
        Score score = new Score(0, 1);
        ResultStringGenerator resultStringGenerator = new ResultStringGeneratorBaseBall();

        //when
        String result = resultStringGenerator.result(score);

        // then

        Assertions.assertEquals("1스트라이크", result);
    }

    @Test
    public void 투_스트라이크() {
        // given
        Score score = new Score(0, 2);
        ResultStringGenerator resultStringGenerator = new ResultStringGeneratorBaseBall();

        //when
        String result = resultStringGenerator.result(score);

        // then

        Assertions.assertEquals("2스트라이크", result);
    }

    @Test
    public void 쓰리_스트라이크() {
        // given
        Score score = new Score(0, 1);
        ResultStringGenerator resultStringGenerator = new ResultStringGeneratorBaseBall();

        //when
        String result = resultStringGenerator.result(score);

        // then

        Assertions.assertEquals("3스트라이크", result);
    }
}
