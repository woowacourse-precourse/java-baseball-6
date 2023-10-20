package baseball.model;

public class GameModel {
    private boolean isRunning;

    public GameModel() {
        this.isRunning = true;
    }

    public boolean isRunning() {
        return isRunning;
    }

    public void setRunning(boolean running) {
        isRunning = running;
    }
}
