package baseball;

import baseball.controller.Controller;
import baseball.view.GameMessage;

public class Application {
    public static void main(String[] args) {
        GameMessage.printStartMessage();
        Controller controller = new Controller();
        controller.run();

    }
}
