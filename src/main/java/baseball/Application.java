package baseball;

import baseball.application.BaseballGame;
import baseball.view.InputView;

public class Application {
    public static void main(String[] args) {

        InputView.printStartGameMessage();
        boolean gameContinue = false;

        while(!gameContinue) {
            new BaseballGame().play();
            gameContinue = InputView.askGameEnd();
        }
    }
}
