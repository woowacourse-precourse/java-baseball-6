package baseball.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import baseball.domain.BallNumber;
import baseball.domain.Result;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ResultCalculatorTest {

    @DisplayName("상대방의 수가 제대로 저장되었는지 확인")
    @Test
    void isCorrectlySaved() {
        ResultCalculator resultCalculator = new ResultCalculator(new BallNumber("123"));
        BallNumber comparisonNumber = new BallNumber("123");

        assertTrue(resultCalculator.computerNumber.ballNumber.equals(comparisonNumber.ballNumber));
    }

    @DisplayName("스트라이크의 개수를 제대로 계산했는지 확인")
    @Test
    void strikesAreCorrect() {
        ResultCalculator resultCalculator = new ResultCalculator(new BallNumber("123"));
        BallNumber comparisonNumber = new BallNumber("125");

        Result result = resultCalculator.calculateResult(comparisonNumber);

        assertEquals(result.numberOfStrikes, 2);
    }

    @DisplayName("볼의 개수를 제대로 계산했는지 확인")
    @Test
    void ballsAreCorrect() {
        ResultCalculator resultCalculator = new ResultCalculator(new BallNumber("643"));
        BallNumber comparisonNumber = new BallNumber("435");

        Result result = resultCalculator.calculateResult(comparisonNumber);

        assertEquals(result.numberOfBalls, 2);
    }
}
