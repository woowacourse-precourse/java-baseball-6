package baseball.domain;

import baseball.domain.dto.Result;
import baseball.global.constant.RuleValue;

import java.util.stream.IntStream;

public final class Referee {

    public Result alertResult(BaseballNumber computerNumber, BaseballNumber playerNumber){
        return new Result(
                countBall(computerNumber, playerNumber),
                countStrike(computerNumber, playerNumber)
        );
    }

    private int countBall(BaseballNumber computerNumber, BaseballNumber playerNumber) {
        return (int) IntStream.range(0, RuleValue.BASEBALL_NUMBER_SIZE)
                .filter(index -> {
                    int num1 = computerNumber.getIndexNumber(index);
                    int num2 = playerNumber.getIndexNumber(index);
                    return num1 != num2 && playerNumber.contains(num1);
                })
                .count();
    }

    private int countStrike(BaseballNumber computerNumber, BaseballNumber playerNumber) {
        return (int) IntStream.range(0, RuleValue.BASEBALL_NUMBER_SIZE)
                .filter(i -> computerNumber.getIndexNumber(i) == playerNumber.getIndexNumber(i))
                .count();
    }
}
