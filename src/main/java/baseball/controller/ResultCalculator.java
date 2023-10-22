package baseball.controller;

import baseball.domain.BallNumber;
import baseball.domain.Result;
import baseball.domain.scoringnumbers.Balls;
import baseball.domain.scoringnumbers.Strikes;
import baseball.system.SystemConstant;
import java.util.stream.IntStream;

public class ResultCalculator {
    BallNumber computerNumber;

    public ResultCalculator(BallNumber newComputerNumber) {
        computerNumber = newComputerNumber;
    }

    public Result calculateResult(BallNumber comparisonNumber) {
        Strikes newStrikes = countStrikes(comparisonNumber);
        Balls newBalls = countBalls(comparisonNumber, newStrikes);

        return new Result(newStrikes, newBalls);
    }

    private Strikes countStrikes(BallNumber comparisonNumber) {
        return new Strikes(IntStream
                .range(0, SystemConstant.MAXIMUM_DIGIT)
                .filter(i ->
                        comparisonNumber.getBallNumberByDigit(i) == computerNumber.getBallNumberByDigit(i))
                .count());
    }

    private Balls countBalls(BallNumber comparisonNumber, Strikes numberOfStrikes) {
        return new Balls(comparisonNumber.ballNumberList
                .stream()
                .filter(computerNumber::hasThis)
                .count() - numberOfStrikes.getValue());
    }
}
