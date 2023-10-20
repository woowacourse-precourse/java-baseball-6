package baseball.domain;

public class GameResult {
    private final int strikes;
    private final int balls;

    public GameResult(int balls, int strikes) {
        this.balls = balls;
        this.strikes = strikes;
    }

    public int getStrikes() {
        return strikes;
    }

    public int getBalls() {
        return balls;
    }

    public boolean isNothing() { return balls == 0 && strikes == 0; }

    public boolean isAllBall() { return balls > 0 && strikes == 0; }

    public boolean isAllStrike() { return balls == 0 && strikes > 0; }

    @Override
    public String toString() {
        return balls + "볼 " + strikes + "스트라이크";
    }
}
