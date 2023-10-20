package baseball.domain;

public class Result {
    public int numberOfStrikes;
    public int numberOfBalls;

    public Result(int newStrikes, int newBalls) {
        numberOfStrikes = newStrikes;
        numberOfBalls = newBalls;
    }

    public boolean isNothing() {
        return (numberOfBalls == 0 && numberOfStrikes == 0);
    }

}
