package baseball;

import baseball.controller.Controller;
import baseball.view.ConsoleInputView;
import baseball.view.ConsoleOutputView;

public class Application {

    public static void main(String[] args) {
        Controller controller = new Controller(new ConsoleInputView(), new ConsoleOutputView());
        controller.start();
    }
}
