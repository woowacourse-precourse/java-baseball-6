package baseball.domain;

public class Player {
    private final Number number;

    public Player(Number number) {
        this.number = number;
    }

    public int countStrike(Number computerNumber) {
        return number.getSamePositionCount(computerNumber);
    }

    public int countBall(Number computerNumber) {
        return number.getContainNumberCount(computerNumber);
    }
}
