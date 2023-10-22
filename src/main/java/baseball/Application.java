package baseball;

import baseball.Controller.BaseballGame;
import baseball.view.OutputView;


public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        OutputView.gameStartMessage();
        BaseballGame baseballGame = new BaseballGame();
        baseballGame.gameStart();
    }
}
