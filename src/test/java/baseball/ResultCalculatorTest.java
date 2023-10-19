package baseball;

import baseball.domain.BallNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ResultCalculatorTest {

    @DisplayName("상대방의 수가 제대로 저장되었는지 확인")
    @Test
    void StrikesIsCorrectlySaved() {
        ResultCalculator resultCalculator = new ResultCalculator(new BallNumber(123));
        BallNumber comparisonNumber = new BallNumber(123);

        assertTrue(resultCalculator.computerNumber.ballnumber.equals(comparisonNumber.ballnumber));
    }
}
