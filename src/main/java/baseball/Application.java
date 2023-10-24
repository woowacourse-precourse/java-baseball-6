package baseball;

import baseball.view.input.Input;
import baseball.view.input.ConsoleInput;
import baseball.view.output.Output;
import baseball.view.output.ConsoleOutput;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        ProcessManager processManager = gameController();
        processManager.runBaseballGame();
    }
    private static ProcessManager gameController() {
        return new ProcessManager(
                input(),
                output());
    }

    private static Input input() {
        return new ConsoleInput();
    }

    private static Output output() {
        return new ConsoleOutput();
    }

}
