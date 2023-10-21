package baseball;

import static baseball.view.Message.StartMessage;

import baseball.controller.BaseballController;

public class Application {
    public static void main(String[] args) {
        BaseballController game = new BaseballController();
        StartMessage();
        game.run();
    }
}
