package baseball.controller;

public class ControllerResolver {
    private final BaseballGameController baseballGameController;

    public ControllerResolver() {
        this.baseballGameController = new BaseballGameController();
    }

    public void run() {
        greet();
        process();
    }

    private void greet() {
        baseballGameController.greet();
    }

    private void process() {
        baseballGameController.decideAnswer();
        while (!baseballGameController.isGameEnd()) {
            baseballGameController.guess();
        }
        baseballGameController.end();
        boolean selectRestartMode = !baseballGameController.isGameEnd();
        if (selectRestartMode) {
            process();
        }
    }
}
