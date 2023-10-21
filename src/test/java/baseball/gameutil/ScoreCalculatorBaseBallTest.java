package baseball.gameutil;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ScoreCalculatorBaseBallTest {

    @Test
    public void 낫_씽(){
        //given
        List<Integer> userInput = List.of(1, 2, 3);
        List<Integer> computerInput = List.of(4, 5, 6);
        ScoreCalculator scoreCalculator = new ScoreCalculatorBaseBall();

        //when
        Score score = scoreCalculator.calScore(userInput, computerInput);

        //then
        Assertions.assertEquals(0, score.ball);
        Assertions.assertEquals(0, score.strike);
    }

    @Test
    public void 원_볼() {
        //given
        List<Integer> userInput = List.of(1, 2, 3);
        List<Integer> computerInput = List.of(3, 4, 5);
        ScoreCalculator scoreCalculator = new ScoreCalculatorBaseBall();

        //when
        Score score = scoreCalculator.calScore(userInput, computerInput);

        //then
        Assertions.assertEquals(1, score.ball);
        Assertions.assertEquals(0, score.strike);
    }

    @Test
    public void 원_볼_원_스트라이크() {
        //given
        List<Integer> userInput = List.of(1, 2, 3);
        List<Integer> computerInput = List.of(3, 2, 5);
        ScoreCalculator scoreCalculator = new ScoreCalculatorBaseBall();

        //when
        Score score = scoreCalculator.calScore(userInput, computerInput);

        //then
        Assertions.assertEquals(1, score.ball);
        Assertions.assertEquals(1, score.strike);
    }

    @Test
    public void 투_볼() {
        //given
        List<Integer> userInput = List.of(1, 2, 3);
        List<Integer> computerInput = List.of(5, 3, 2);
        ScoreCalculator scoreCalculator = new ScoreCalculatorBaseBall();

        //when
        Score score = scoreCalculator.calScore(userInput, computerInput);

        //then
        Assertions.assertEquals(2, score.ball);
        Assertions.assertEquals(0, score.strike);
    }

    @Test
    public void 투_볼_원_스트라이크() {
        //given
        List<Integer> userInput = List.of(1, 2, 3);
        List<Integer> computerInput = List.of(1, 3, 2);
        ScoreCalculator scoreCalculator = new ScoreCalculatorBaseBall();

        //when
        Score score = scoreCalculator.calScore(userInput, computerInput);

        //then
        Assertions.assertEquals(2, score.ball);
        Assertions.assertEquals(1, score.strike);
    }

    @Test
    public void 쓰리_볼() {
        //given
        List<Integer> userInput = List.of(1, 2, 3);
        List<Integer> computerInput = List.of(3, 1, 2);
        ScoreCalculator scoreCalculator = new ScoreCalculatorBaseBall();

        //when
        Score score = scoreCalculator.calScore(userInput, computerInput);

        //then
        Assertions.assertEquals(3, score.ball);
        Assertions.assertEquals(0, score.strike);
    }

    @Test
    public void 원_스트라이크() {
        //given
        List<Integer> userInput = List.of(1, 2, 3);
        List<Integer> computerInput = List.of(1, 4, 5);
        ScoreCalculator scoreCalculator = new ScoreCalculatorBaseBall();

        //when
        Score score = scoreCalculator.calScore(userInput, computerInput);

        //then
        Assertions.assertEquals(0, score.ball);
        Assertions.assertEquals(1, score.strike);
    }

    @Test
    public void 투_스트라이크() {
        //given
        List<Integer> userInput = List.of(1, 2, 3);
        List<Integer> computerInput = List.of(1, 2, 5);
        ScoreCalculator scoreCalculator = new ScoreCalculatorBaseBall();

        //when
        Score score = scoreCalculator.calScore(userInput, computerInput);

        //then
        Assertions.assertEquals(0, score.ball);
        Assertions.assertEquals(2, score.strike);
    }

    @Test
    public void 쓰리_스트라이크() {
        //given
        List<Integer> userInput = List.of(1, 2, 3);
        List<Integer> computerInput = List.of(1, 2, 3);
        ScoreCalculator scoreCalculator = new ScoreCalculatorBaseBall();

        //when
        Score score = scoreCalculator.calScore(userInput, computerInput);

        //then
        Assertions.assertEquals(0, score.ball);
        Assertions.assertEquals(3, score.strike);
    }

}
