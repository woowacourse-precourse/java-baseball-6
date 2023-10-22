package baseball.domain;

public class Result {
    public Strikes numberOfStrikes;
    public Balls numberOfBalls;

    public Result(Strikes newStrikes, Balls newBalls) {
        numberOfStrikes = newStrikes;
        numberOfBalls = newBalls;
    }

    public boolean isNothing() {
        return numberOfBalls.isZero() && numberOfStrikes.isZero();
    }

    public boolean isStrikesAllOfBalls() {
        return numberOfStrikes.isStrikeAllOfBalls();
    }
}