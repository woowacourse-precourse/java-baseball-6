package baseball;

import baseball.View.GameMessage;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        GameMessage.gameStartMessage();
        Controller controller = new Controller();
        controller.run();
    }
}