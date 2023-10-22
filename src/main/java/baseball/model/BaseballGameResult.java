package baseball.model;

import java.util.List;
import java.util.stream.Stream;

public class BaseballGameResult {

    private final int ball;
    private final int strike;


    public BaseballGameResult(List<Integer> userNumber, List<Integer> computerNumber) {
        this.ball = countBall(userNumber,computerNumber);
        this.strike = countStrike(userNumber,computerNumber);
    }

    public int getBall() {
        return ball;
    }

    public int getStrike() {
        return strike;
    }

    private int countBall(List<Integer> userNumber, List<Integer> computerNumber) {
        return (int) Stream.iterate(0, i -> i + 1).limit(3)
                .filter(i -> userNumber.get(i) != computerNumber.get(i) && computerNumber.contains(userNumber.get(i)))
                .count();
    }

    private int countStrike(List<Integer> userNumber, List<Integer> computerNumber) {
        return (int) Stream.iterate(0, i -> i + 1).limit(3)
                .filter(i -> userNumber.get(i) == computerNumber.get(i))
                .count();
    }
}
