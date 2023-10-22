package baseball;

import baseball.controller.Controller;
import baseball.view.ConsoleInputView;
import baseball.view.ConsoleOutputView;

public class Application {

    public static void main(String[] args) {
        ConsoleOutputView consoleOutputView = new ConsoleOutputView();
        Controller controller = new Controller(new ConsoleInputView(consoleOutputView), consoleOutputView);
        controller.start();
    }
}
