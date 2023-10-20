package baseball.model;

public class GameModel {
    private int[] scores;
    private boolean isRunning;

    public GameModel() {
        this.isRunning = true;
    }

    public int[] getScores() {
        return scores;
    }

    public boolean isRunning() {
        return isRunning;
    }
}
