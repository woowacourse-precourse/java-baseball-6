package baseball.controller;

import baseball.domain.BallNumber;
import baseball.domain.Result;
import baseball.system.SystemConstant;
import java.util.stream.IntStream;

public class ResultCalculator {
    BallNumber computerNumber;

    public ResultCalculator(BallNumber newComputerNumber) {
        computerNumber = newComputerNumber;
    }

    public Result calculateResult(BallNumber comparisonNumber) {
        int newStrikes = (int) IntStream.range(0, SystemConstant.MAXIMUM_DIGIT)
                .filter(i ->
                        isStrike(comparisonNumber.getBallNumberByDigit(i), i))
                .count();
        int newBalls = (int) comparisonNumber.ballNumber.stream()
                .filter(this::ballInThisArea)
                .count() - newStrikes;

        return new Result(newStrikes, newBalls);
    }

    private boolean isStrike(int eachNumber, int digit) {
        return NumberComparator.isEqual(eachNumber, computerNumber.getBallNumberByDigit(digit));
    }

    private boolean ballInThisArea(int eachNumber) {
        return computerNumber.ballNumber.contains(eachNumber);
    }
}
