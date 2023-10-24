package baseball.model;

import baseball.utils.Constant;
import java.util.List;
import java.util.stream.Stream;

public class GameResult {
    private final int ball;
    private final int strike;

    public GameResult(List<Integer> computerNumber, List<Integer> playerNumber) {
        this.ball = countBall(computerNumber, playerNumber);
        this.strike = countStrike(computerNumber, playerNumber);
    }

    public int countBall(List<Integer> computerNumber, List<Integer> playerNumber) {
        return (int) Stream.iterate(0, i -> i + 1).limit(Constant.LENGTH)
            .filter(i -> !playerNumber.get(i).equals(computerNumber.get(i)) && computerNumber.contains(playerNumber.get(i)))
            .count();
    }

    public int countStrike(List<Integer> computerNumber, List<Integer> playerNumber) {
        return (int) Stream.iterate(0, i -> i + 1).limit(Constant.LENGTH)
            .filter(i -> playerNumber.get(i).equals(computerNumber.get(i)))
            .count();
    }

    public int getBall() {
        return ball;
    }

    public int getStrike() {
        return strike;
    }
}
