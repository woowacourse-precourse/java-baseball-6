package baseball.controller;

abstract class GameController {
    boolean isRunning;

    public GameController(boolean isRunning) {
        this.isRunning = isRunning;
    }

    public abstract void start();

    public abstract void startGame();
}
