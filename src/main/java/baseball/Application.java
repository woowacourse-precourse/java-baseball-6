package baseball;

import baseball.view.input.Input;
import baseball.view.input.InputImpl;
import baseball.view.output.Output;
import baseball.view.output.OutputImpl;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        GameController gameController = gameController();
        gameController.runBaseballGame();
    }
    private static GameController gameController() {
        return new GameController(
                input(),
                output());
    }

    private static Input input() {
        return new InputImpl();
    }

    private static Output output() {
        return new OutputImpl();
    }

}
