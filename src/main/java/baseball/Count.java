package baseball;

public class Count {
    private int ballCount;
    private int strikeCount;

    public Count() {
        ballCount = 0;
        strikeCount = 0;
    }

    public void increaseBall() {
        ballCount++;
    }

    public void increaseStrike() {
        strikeCount++;
    }

    public void initialize() {
        ballCount = 0;
        strikeCount = 0;
    }

    public int getBallCount() {
        return ballCount;
    }

    public int getStrikeCount() {
        return strikeCount;
    }
}
