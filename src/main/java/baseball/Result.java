package baseball;

public class Result {
    private int NumberOfBalls;
    private int NumberOfStrikes;

    public Result(int numberOfBalls, int numberOfStrikes) {
        NumberOfBalls = numberOfBalls;
        NumberOfStrikes = numberOfStrikes;
    }

    public int getNumberOfBalls() {
        return NumberOfBalls;
    }

    public int getNumberOfStrikes() {
        return NumberOfStrikes;
    }
}
