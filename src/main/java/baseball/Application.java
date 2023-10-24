package baseball;

import baseball.controllers.GameController;
import baseball.views.OutputView;
public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        OutputView.printGameStart();
        GameController baseballGame = new GameController();
        baseballGame.start();
    }
}
