package baseball;

public class Game {
    private int strikes;
    private int balls;

    public Game(int strikes, int balls) {
        this.strikes = strikes;
        this.balls = balls;
    }

    public int getStrikes() {
        return strikes;
    }

    public int getBalls() {
        return balls;
    }

    public boolean isNothing() {
        return strikes == 0 && balls == 0;
    }

    public boolean isWin(int targetCount) {
        return strikes == targetCount;
    }
}
