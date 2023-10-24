package baseball.controller;

public class ControllerResolver {
    private final GameController gameController;

    public ControllerResolver() {
        this.gameController = new GameController();
    }

    public void run() {
        greet();
        process();
    }

    public void greet() {
        gameController.greet();
    }

    private void process() {
        gameController.decideAnswer();
        while (!gameController.isGameEnd()) {
            gameController.guess();
        }
        gameController.end();
        boolean selectRestartMode = !gameController.isGameEnd();
        if(selectRestartMode)
            process();
    }
}
