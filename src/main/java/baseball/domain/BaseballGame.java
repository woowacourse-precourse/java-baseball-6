package baseball.domain;

import java.util.stream.IntStream;

public class BaseballGame {
    private static final int NUMBER_SIZE = 3;

    private final Computer computer;
    private final Player player;

    public BaseballGame(Computer computer, Player player) {
        this.computer = computer;
        this.player = player;
    }

    public Baseball compare() {
        int strike = countStrike();
        int ball = countBall();
        return new Baseball(ball, strike);
    }

    private int countStrike() {
        return (int) IntStream.range(0, NUMBER_SIZE)
                .filter(idx -> computer.compareStrike(player, idx))
                .count();
    }

    private int countBall() {
        return (int) IntStream.range(0, NUMBER_SIZE)
                .filter(idx -> computer.compareBall(player, idx))
                .count();
    }
}
