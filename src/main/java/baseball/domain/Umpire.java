package baseball.domain;

import static baseball.global.BaseballConstant.GUESS_NUMBER_SIZE;

import java.util.stream.IntStream;

public class Umpire {

    private final int strikeCount;
    private final int ballCount;

    public Umpire(Computer computer, Player player) {
        this.strikeCount = countStrike(computer, player);
        this.ballCount = countBall(computer, player);
    }

    private int countStrike(Computer computer, Player player) {
        return (int) IntStream.range(0, GUESS_NUMBER_SIZE)
                .filter(i -> computer.getNumberOf(i) == player.getNumberOf(i))
                .count();
    }

    private int countBall(Computer computer, Player player) {
        return (int) IntStream.range(0, GUESS_NUMBER_SIZE)
                .map(player::getNumberOf)
                .filter(computer::numbersContains)
                .count() - countStrike(computer, player);
    }

    public boolean isNothing() {
        return this.strikeCount == 0 && this.ballCount == 0;
    }

    public boolean isThreeStrike() {
        return this.strikeCount == 3;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }
}
