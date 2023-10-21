package baseball.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ResultTest {

    @Test
    void Result_결과값_생성_낫싱() {
        int ball = 0;
        int strike = 0;
        Result result = new Result(ball,strike);

        String outputMessage = result.getOutputMessage();

        Assertions.assertEquals("낫싱",outputMessage);
    }

    @Test
    void Result_결과값_생성_볼() {
        int ball = 1;
        int strike = 0;
        Result result = new Result(ball,strike);

        String outputMessage = result.getOutputMessage();

        Assertions.assertEquals("1볼",outputMessage);
    }

    @Test
    void Result_결과값_생성_스트라이크() {
        int ball = 0;
        int strike = 1;
        Result result = new Result(ball,strike);

        String outputMessage = result.getOutputMessage();

        Assertions.assertEquals("1스트라이크",outputMessage);
    }

    @Test
    void Result_결과값_생성_볼과_스트라이크() {
        int ball = 2;
        int strike = 1;
        Result result = new Result(ball,strike);

        String outputMessage = result.getOutputMessage();

        Assertions.assertEquals("2볼 1스트라이크",outputMessage);
    }

    @Test
    void Result_결과값_생성_3스트라이크() {
        int ball = 0;
        int strike = 3;
        Result result = new Result(ball,strike);

        String outputMessage = result.getOutputMessage();

        Assertions.assertEquals("3스트라이크",outputMessage);
    }
}
