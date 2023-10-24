package baseball.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import baseball.domain.BallNumber;
import baseball.domain.GameScore;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GameScoreCalculatorTest {

    @DisplayName("상대방의 수가 제대로 저장되었는지 확인")
    @Test
    void isCorrectlySaved() {
        ResultCalculator resultCalculator = new ResultCalculator(new BallNumber("123"));
        BallNumber comparisonNumber = new BallNumber("123");

        assertEquals(resultCalculator.computerNumber.ballNumberList, comparisonNumber.ballNumberList);
    }

    @DisplayName("스트라이크의 개수를 제대로 계산했는지 확인")
    @Test
    void strikesAreCorrect() {
        ResultCalculator resultCalculator = new ResultCalculator(new BallNumber("123"));
        BallNumber comparisonNumber = new BallNumber("125");

        GameScore gameScore = resultCalculator.calculateResult(comparisonNumber);

        assertEquals(gameScore.numberOfStrikes.get(), 2);
    }

    @DisplayName("볼의 개수를 제대로 계산했는지 확인")
    @Test
    void ballsAreCorrect() {
        ResultCalculator resultCalculator = new ResultCalculator(new BallNumber("643"));
        BallNumber comparisonNumber = new BallNumber("435");

        GameScore gameScore = resultCalculator.calculateResult(comparisonNumber);

        assertEquals(gameScore.numberOfBalls.get(), 2);
    }
}
