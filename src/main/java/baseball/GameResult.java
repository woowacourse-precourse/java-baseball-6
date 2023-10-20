package baseball;

public class GameResult {
    private int strikes;
    private int balls;

    public GameResult(int strikes, int balls) {
        this.strikes = strikes;
        this.balls = balls;
    }

    public boolean isGameWon() {
        return strikes == 3;
    }

    @Override
    public String toString() {
        if (strikes == 0 && balls == 0) {
            return "낫싱";
        }
        return strikes + "스트라이크 " + balls + "볼";
    }
}