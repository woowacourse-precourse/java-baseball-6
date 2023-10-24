package baseball.model;

public class Game {
    private static final int INIT_COUNT = 0;
    private int strikeCount;
    private int ballCount;

    public Game() {
        initStrikeAndBall();
    }

    public void initStrikeAndBall() {
        this.strikeCount = INIT_COUNT;
        this.ballCount = INIT_COUNT;
    }

    public void plusStrikeCount(int strikeCount) {
        this.strikeCount += strikeCount;
    }

    public void plusBallCount(int ballCount) {
        this.ballCount += ballCount;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }
}
