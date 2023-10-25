package baseball.domain;

import static baseball.global.BaseballConstant.GUESS_NUMBER_SIZE;

import java.util.stream.IntStream;

public class Umpire {

    private final int ballCount;
    private final int strikeCount;

    public Umpire(Computer computer, Player player) {
        this.ballCount = countBall(computer, player);
        this.strikeCount = countStrike(computer, player);
    }

    private int countBall(Computer computer, Player player) {
        return (int) IntStream.range(0, GUESS_NUMBER_SIZE)
                .map(player::getNumberOf)
                .filter(computer::numbersContains)
                .count() - countStrike(computer, player);
    }

    private int countStrike(Computer computer, Player player) {
        return (int) IntStream.range(0, GUESS_NUMBER_SIZE)
                .filter(i -> computer.getNumberOf(i) == player.getNumberOf(i))
                .count();
    }

    public int getBallCount() {
        return ballCount;
    }

    public int getStrikeCount() {
        return strikeCount;
    }
}
