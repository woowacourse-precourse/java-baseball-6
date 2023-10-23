package baseball.controller;

abstract class GameController {
    protected boolean isRunning;

    public GameController(boolean running) {
        this.isRunning = running;
    }

    public abstract void start();

    public abstract void startGame();
}
