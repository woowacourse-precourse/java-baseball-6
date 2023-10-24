package baseball;

import baseball.logic.Logic;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LogicTest {

    @Test
    public void scoringResultTest() {
        int inputAnswer = 123;
        int correctAnswer = 321;

        Logic logic = new Logic();

        int[] scores = logic.scoringResult(inputAnswer, correctAnswer);

        Assertions.assertEquals(1, scores[0]);
        Assertions.assertEquals(2, scores[1]);
    }
}
