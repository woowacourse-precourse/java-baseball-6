package baseball;

import baseball.controller.GameController;
import baseball.view.GameView;

public class Application {


    public static void main(String[] args) {
        // TODO: 프로그램 구현
        GameController client = new GameController(new GameView());
        client.run();
    }
}
