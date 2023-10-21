package baseball.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ResultTest {

    @Test
    void Result_결과값_생성_낫싱() {
        List<Integer> inputAnswer = List.of(1, 2, 3);
        List<Integer> randomNumbers = List.of(5, 6, 7);
        Result result = new Result(inputAnswer,randomNumbers);

        String outputMessage = result.getOutputMessage();

        Assertions.assertEquals("낫싱",outputMessage);
    }

    @Test
    void Result_결과값_생성_볼() {
        List<Integer> inputAnswer = List.of(1, 2, 3);
        List<Integer> randomNumbers = List.of(2, 4, 5);
        Result result = new Result(inputAnswer,randomNumbers);

        String outputMessage = result.getOutputMessage();

        Assertions.assertEquals("1볼",outputMessage);
    }

    @Test
    void Result_결과값_생성_스트라이크() {
        List<Integer> inputAnswer = List.of(1, 2, 3);
        List<Integer> randomNumbers = List.of(1, 4, 5);
        Result result = new Result(inputAnswer,randomNumbers);

        String outputMessage = result.getOutputMessage();

        Assertions.assertEquals("1스트라이크",outputMessage);
    }

    @Test
    void Result_결과값_생성_볼과_스트라이크() {
        List<Integer> inputAnswer = List.of(1, 2, 3);
        List<Integer> randomNumbers = List.of(1, 3, 2);
        Result result = new Result(inputAnswer,randomNumbers);

        String outputMessage = result.getOutputMessage();

        Assertions.assertEquals("2볼 1스트라이크",outputMessage);
    }

    @Test
    void Result_결과값_생성_3스트라이크() {
        List<Integer> inputAnswer = List.of(1, 2, 3);
        List<Integer> randomNumbers = List.of(1, 2, 3);
        Result result = new Result(inputAnswer,randomNumbers);

        String outputMessage = result.getOutputMessage();

        Assertions.assertEquals("3스트라이크",outputMessage);
    }
}