package baseball;

import baseball.domain.BallNumber;
import baseball.domain.Result;

public class ResultCalculator {
    BallNumber computerNumber;

    ResultCalculator(BallNumber newComputerNumber) {
        computerNumber = newComputerNumber;
    }

    public Result calculateResult(BallNumber comparisonNumber) {
        return new Result(0,0);
    }
}
